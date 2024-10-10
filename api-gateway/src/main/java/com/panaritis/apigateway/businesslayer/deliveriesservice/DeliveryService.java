package com.panaritis.apigateway.businesslayer.deliveriesservice;

import com.panaritis.apigateway.presentationlayer.deliverydto.DeliveryRequestModel;
import com.panaritis.apigateway.presentationlayer.deliverydto.DeliveryResponseModel;

import java.util.List;

public interface DeliveryService {
    List<DeliveryResponseModel> getDeliveries();

    DeliveryResponseModel getDeliveriesByDeliveryId(String deliveryId);

    DeliveryResponseModel addDelivery(DeliveryRequestModel deliveryRequestModel);

    DeliveryResponseModel updateDelivery(DeliveryRequestModel deliveryRequestModel, String deliveryId);

    void removeDelivery(String deliveryId);
}
