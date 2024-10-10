package com.panaritis.apigateway.businesslayer.purchasesservices;

import com.panaritis.apigateway.presentationlayer.purchasedto.PurchaseRequestModel;
import com.panaritis.apigateway.presentationlayer.purchasedto.PurchaseResponseModel;

import java.util.List;

public interface PurchaseService {

    List<PurchaseResponseModel> getAllPurchasesForCustomer(String customerId);

    PurchaseResponseModel getCustomerPurchaseByPurchaseId(String customerId, String purchaseId);

    PurchaseResponseModel addPurchaseToCustomer(PurchaseRequestModel purchaseRequestModel, String customerId);

    PurchaseResponseModel updateCustomerPurchase(PurchaseRequestModel purchaseRequestModel, String customerId, String purchaseId);

    void removePurchaseFromCustomer(String customerId, String purchaseId);


}
