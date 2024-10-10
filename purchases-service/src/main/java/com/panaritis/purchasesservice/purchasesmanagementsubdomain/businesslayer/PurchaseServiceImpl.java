package com.panaritis.purchasesservice.purchasesmanagementsubdomain.businesslayer;


import com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer.PurchaseIdentifier;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.furniture.FurnitureModel;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.deliveries.DeliveryModel;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.presentationlayer.PurchaseRequestModel;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.utils.exceptions.NotFoundException;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer.Purchase;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer.PurchaseRepository;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.datamapperlayer.PurchaseRequestMapper;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.datamapperlayer.PurchaseResponseMapper;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.customers.CustomerModel;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.customers.CustomersServiceClient;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.deliveries.DeliveryServiceClient;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.furniture.FurnitureServiceClient;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.presentationlayer.PurchaseResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final CustomersServiceClient customersServiceClient;
    private final DeliveryServiceClient deliveriesServiceClient;
    private final FurnitureServiceClient furnitureServiceClient;
    private final PurchaseRequestMapper purchaseRequestMapper;
    private final PurchaseResponseMapper purchaseResponseMapper;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, CustomersServiceClient customersServiceClient, DeliveryServiceClient deliveriesServiceClient,
                               FurnitureServiceClient furnitureServiceClient, PurchaseRequestMapper purchaseRequestMapper,
                               PurchaseResponseMapper purchaseResponseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.customersServiceClient = customersServiceClient;
        this.deliveriesServiceClient = deliveriesServiceClient;
        this.furnitureServiceClient = furnitureServiceClient;
        this.purchaseRequestMapper = purchaseRequestMapper;
        this.purchaseResponseMapper = purchaseResponseMapper;
    }

    @Override
    public List<PurchaseResponseModel> getAllPurchasesForCustomer(String customerId) {
        CustomerModel customerModel = customersServiceClient.getCustomerByCustomerId(customerId);
        if (customerModel == null) {
            throw new NotFoundException("Invalid customerId: " + customerId);
        }

        List<Purchase> purchaseList = purchaseRepository.findPurchaseByCustomerModel_CustomerId(customerId);
//        List<PurchaseResponseModel> purchaseResponseModelList = new ArrayList<>();

//        purchaseList.forEach(purchase -> {
//
//            DeliveryModel delivery = deliveriesServiceClient.getDeliveryByDeliveryId(purchase.getDeliveryModel().getDeliveryId());
//            if (delivery == null) {
//                throw new NotFoundException("Invalid deliveryId: " + purchase.getDeliveryModel().getDeliveryId());
//            }
//
//            FurnitureModel furniture = furnitureServiceClient.getFurnitureByFurnitureId(purchase.getFurnitureModel().getFurnitureId());
//
//            if (furniture == null) {
//                throw new NotFoundException("Invalid furnitureId: " + purchase.getFurnitureModel().getFurnitureId());
//            }
//            purchaseResponseModelList.add(purchaseResponseMapper.entityToResponseModelList(purchase));
//        });
        return purchaseResponseMapper.entityToResponseModelList(purchaseList);
    }

    @Override
    public PurchaseResponseModel getCustomerPurchaseByPurchaseId(String customerId, String purchaseId) {
        CustomerModel customer = customersServiceClient.getCustomerByCustomerId(customerId);
        if (customer == null) {
            throw new NotFoundException("Invalid customerId: " + customerId);
        }

        Purchase customerPurchases = purchaseRepository.findPurchaseByCustomerModel_CustomerIdAndPurchaseIdentifier_PurchaseId(customerId, purchaseId);
        if (customerPurchases == null) {
            throw new NotFoundException("Invalid purchaseId: " + purchaseId);
        }

//        Delivery delivery = deliveryRepository.findByDeliveryIdentifier_DeliveryId(purchase.getDeliveryIdentifier().getDeliveryId());
//        if (delivery == null) {
//            throw new NotFoundException("Invalid deliveryId: " + purchase.getDeliveryIdentifier().getDeliveryId());
//        }
//        Furniture furniture = furnitureRepository.findByFurnitureIdentifier_FurnitureId(purchase.getFurnitureIdentifier().getFurnitureId());
//        if (furniture == null) {
//            throw new NotFoundException("Invalid furnitureId: " + purchase.getFurnitureIdentifier().getFurnitureId());
//        }

        return purchaseResponseMapper.entityToResponseModel(customerPurchases);
    }

    @Override
    public PurchaseResponseModel addPurchaseToCustomer(PurchaseRequestModel purchaseRequestModel, String customerId) {

        CustomerModel customerModel = customersServiceClient.getCustomerByCustomerId(customerId);
        if (customerModel == null) {
            throw new NotFoundException("Invalid customerId: " + purchaseRequestModel.getCustomerId());
        }

        DeliveryModel deliveryModel = deliveriesServiceClient.getDeliveryByDeliveryId(purchaseRequestModel.getDeliveryId());
        if (deliveryModel == null) {
            throw new NotFoundException("Invalid deliveryId: " + purchaseRequestModel.getDeliveryId());
        }
        FurnitureModel furnitureModel = furnitureServiceClient.getFurnitureByFurnitureId(purchaseRequestModel.getFurnitureId());
        if (furnitureModel == null) {
            throw new NotFoundException("Invalid furnitureId: " + purchaseRequestModel.getFurnitureId());
        }

        Purchase purchase = purchaseRequestMapper.requestModelToEntity(purchaseRequestModel, new PurchaseIdentifier(), customerModel, deliveryModel, furnitureModel);
        Purchase newPurchase = purchaseRepository.save(purchase);
        return purchaseResponseMapper.entityToResponseModel(newPurchase);
    }

    @Override
    public PurchaseResponseModel updateCustomerPurchase(PurchaseRequestModel purchaseRequestModel, String customerId, String purchaseId) {
        CustomerModel foundCustomer = customersServiceClient.getCustomerByCustomerId(customerId);
        if (foundCustomer == null) {
            throw new NotFoundException("customer provided is unknown " + purchaseId);

        }
        DeliveryModel foundDelivery = deliveriesServiceClient.getDeliveryByDeliveryId(purchaseRequestModel.getDeliveryId());
        if (foundDelivery == null) {
            throw new NotFoundException("Invalid furniture: " + purchaseRequestModel.getCustomerId());
        }

        FurnitureModel existingFurniture = furnitureServiceClient.getFurnitureByFurnitureId(purchaseRequestModel.getFurnitureId());
        if (existingFurniture == null) {
            throw new NotFoundException("Invalid furnitureId: " + purchaseRequestModel.getFurnitureId());
        }
        Purchase purchase = purchaseRequestMapper.requestModelToEntity(purchaseRequestModel, new PurchaseIdentifier(),
                foundCustomer, foundDelivery, existingFurniture);

        Purchase savedPurchase = purchaseRepository.save(purchase);

        return purchaseResponseMapper.entityToResponseModel(savedPurchase);
    }

    @Override
    public void removePurchaseFromCustomer(String customerId, String purchaseId) {
        CustomerModel customerModel = customersServiceClient.getCustomerByCustomerId(customerId);

        if (customerModel == null) {
            throw new NotFoundException("Invalid customerId: " + customerId);
        }
        Purchase foundPurchase = purchaseRepository.findPurchaseByCustomerModel_CustomerIdAndPurchaseIdentifier_PurchaseId(customerId, purchaseId);

        if (foundPurchase == null) {
            throw new NotFoundException("Invalid purchaseId: " + purchaseId);
        }

        purchaseRepository.delete(foundPurchase);
//        //Invariant:
//        purchase.setStatus(Status.PURCHASE_CANCELED);
//        purchaseRepository.save(purchase);
    }
}
