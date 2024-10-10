package com.panaritis.deliveriesservice.deliverymanagementsubdomain.businesslayer;


import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer.Delivery;

import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer.DeliveryIdentifier;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer.DeliveryRepository;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer.TransportDetails;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datamapperlayer.DeliveryRequestMapper;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datamapperlayer.DeliveryResponseMapper;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer.DeliveryRequestModel;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer.DeliveryResponseModel;
import com.panaritis.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryResponseMapper deliveryResponseMapper;
    private final DeliveryRequestMapper deliveryRequestMapper;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryResponseMapper deliveryResponseMapper, DeliveryRequestMapper deliveryRequestMapper) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryResponseMapper = deliveryResponseMapper;
        this.deliveryRequestMapper = deliveryRequestMapper;
    }

    @Override
    public List<DeliveryResponseModel> getDeliveries() {
        List<Delivery> deliveries = deliveryRepository.findAll();

        return deliveryResponseMapper.entityToResponseModelList(deliveries);
    }

    @Override
    public DeliveryResponseModel getDeliveriesByDeliveryId(String deliveryId) {
        Delivery delivery = deliveryRepository.findByDeliveryIdentifier_DeliveryId(deliveryId);

        if (delivery == null) {
            throw new NotFoundException("Unknown delivery: " + deliveryId);
        }

        return deliveryResponseMapper.entityToResponseModel(delivery);
    }

    @Override
    public DeliveryResponseModel addDelivery(DeliveryRequestModel deliveryRequestModel) {
        TransportDetails transportDetails = new TransportDetails(deliveryRequestModel.getWarehouseLocation(),
                deliveryRequestModel.getDeliveryDate(), deliveryRequestModel.getEta(), deliveryRequestModel.getShippingNumber());

        Delivery delivery = deliveryRequestMapper.requestModelToEntity(deliveryRequestModel, new DeliveryIdentifier(), transportDetails);

        delivery.setTransportDetails(transportDetails);
        return deliveryResponseMapper.entityToResponseModel(deliveryRepository.save(delivery));
    }

    @Override
    public DeliveryResponseModel updateDelivery(DeliveryRequestModel deliveryRequestModel, String deliveryId) {
        Delivery existingDelivery = deliveryRepository.findByDeliveryIdentifier_DeliveryId(deliveryId);
        if (existingDelivery == null) {
            throw new NotFoundException("unknown deliveryId " + deliveryId);
        }
        TransportDetails transportDetails = new TransportDetails(deliveryRequestModel.getWarehouseLocation(),
                deliveryRequestModel.getDeliveryDate(), deliveryRequestModel.getEta(), deliveryRequestModel.getShippingNumber());
        Delivery updatedDelivery = deliveryRequestMapper.requestModelToEntity(deliveryRequestModel, existingDelivery.getDeliveryIdentifier(), transportDetails);
        updatedDelivery.setId(existingDelivery.getId());
        Delivery response = deliveryRepository.save(updatedDelivery);


        return deliveryResponseMapper.entityToResponseModel(response);
    }

    @Override
    public void removeDelivery(String deliveryId) {
        Delivery existingDelivery = deliveryRepository.findByDeliveryIdentifier_DeliveryId(deliveryId);
        if (existingDelivery == null) {
            throw new NotFoundException("Unknown deliveryId " + deliveryId);
        }
        deliveryRepository.delete(existingDelivery);
    }
}
