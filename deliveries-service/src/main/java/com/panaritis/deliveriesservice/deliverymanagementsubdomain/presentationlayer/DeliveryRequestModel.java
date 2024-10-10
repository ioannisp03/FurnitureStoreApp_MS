package com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DeliveryRequestModel {
     String deliveryId;
     String firstName;
     String lastName;
     String address;
     String warehouseLocation;
     LocalDate deliveryDate;
     String eta;
     String shippingNumber;
     String email;
//     Customer customer;
}
