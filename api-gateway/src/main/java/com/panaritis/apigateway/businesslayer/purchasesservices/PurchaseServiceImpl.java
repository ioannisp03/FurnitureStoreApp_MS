package com.panaritis.apigateway.businesslayer.purchasesservices;

import com.panaritis.apigateway.datamapperlayer.purchasemappers.PurchaseResponseMapper;
import com.panaritis.apigateway.domainclientlayer.PurchaseServiceClient;
import com.panaritis.apigateway.presentationlayer.purchasedto.PurchaseRequestModel;
import com.panaritis.apigateway.presentationlayer.purchasedto.PurchaseResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseServiceClient purchaseServiceClient;
    private final PurchaseResponseMapper purchaseResponseMapper;

    public PurchaseServiceImpl(PurchaseServiceClient purchaseServiceClient, PurchaseResponseMapper purchaseResponseMapper) {
        this.purchaseServiceClient = purchaseServiceClient;
        this.purchaseResponseMapper = purchaseResponseMapper;
    }

    @Override
    public List<PurchaseResponseModel> getAllPurchasesForCustomer(String customerId) {
        return purchaseServiceClient.getPurchases(customerId);
    }

    @Override
    public PurchaseResponseModel getCustomerPurchaseByPurchaseId(String customerId, String purchaseId) {
        return purchaseServiceClient.getPurchaseByPurchaseId(customerId, purchaseId);
    }

    @Override
    public PurchaseResponseModel addPurchaseToCustomer(PurchaseRequestModel purchaseRequestModel, String customerId) {
        return purchaseServiceClient.addPurchase(customerId, purchaseRequestModel);
    }

    @Override
    public PurchaseResponseModel updateCustomerPurchase(PurchaseRequestModel purchaseRequestModel, String customerId, String purchaseId) {
      return  purchaseServiceClient.updatePurchase(purchaseRequestModel, purchaseId, customerId);
    }

    @Override
    public void removePurchaseFromCustomer(String customerId, String purchaseId) {
        purchaseServiceClient.deletePurchase(purchaseId, customerId);

    }
}
