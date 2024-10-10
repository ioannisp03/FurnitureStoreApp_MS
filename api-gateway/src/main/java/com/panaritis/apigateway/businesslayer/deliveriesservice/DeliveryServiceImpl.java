package com.panaritis.apigateway.businesslayer.deliveriesservice;

import com.panaritis.apigateway.datamapperlayer.deliverymappers.DeliveryResponseMapper;
import com.panaritis.apigateway.domainclientlayer.DeliveryServiceClient;
import com.panaritis.apigateway.presentationlayer.deliverydto.DeliveryRequestModel;
import com.panaritis.apigateway.presentationlayer.deliverydto.DeliveryResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryServiceClient deliveryServiceClient;
    private final DeliveryResponseMapper deliveryResponseMapper;

    public DeliveryServiceImpl(DeliveryServiceClient deliveryServiceClient, DeliveryResponseMapper deliveryResponseMapper) {
        this.deliveryServiceClient = deliveryServiceClient;
        this.deliveryResponseMapper = deliveryResponseMapper;
    }


    @Override
    public List<DeliveryResponseModel> getDeliveries() {
        return deliveryServiceClient.getDeliveries();
    }

    @Override
    public DeliveryResponseModel getDeliveriesByDeliveryId(String deliveryId) {
        return this.deliveryServiceClient.getDeliveryByDeliveryId(deliveryId);
    }

    @Override
    public DeliveryResponseModel addDelivery(DeliveryRequestModel deliveryRequestModel) {
        return this.deliveryServiceClient.addDelivery(deliveryRequestModel);
    }

    @Override
    public DeliveryResponseModel updateDelivery(DeliveryRequestModel deliveryRequestModel, String deliveryId) {
        return this.deliveryServiceClient.updateDeliveries(deliveryId, deliveryRequestModel);
    }
    @Override
    public void removeDelivery(String deliveryId) {
        this.deliveryServiceClient.deleteDelivery(deliveryId);
    }
}
