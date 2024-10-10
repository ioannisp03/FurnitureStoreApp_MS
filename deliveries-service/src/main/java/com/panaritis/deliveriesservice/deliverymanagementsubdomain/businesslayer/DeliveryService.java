package com.panaritis.deliveriesservice.deliverymanagementsubdomain.businesslayer;


import com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer.DeliveryRequestModel;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer.DeliveryResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeliveryService {
    List<DeliveryResponseModel> getDeliveries();

    DeliveryResponseModel getDeliveriesByDeliveryId(String deliveryId);

    DeliveryResponseModel addDelivery(DeliveryRequestModel deliveryRequestModel);

    DeliveryResponseModel updateDelivery(DeliveryRequestModel deliveryRequestModel, String deliveryId);

    void removeDelivery(String deliveryId);
}
