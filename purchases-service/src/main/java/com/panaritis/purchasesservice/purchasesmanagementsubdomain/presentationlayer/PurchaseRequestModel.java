package com.panaritis.purchasesservice.purchasesmanagementsubdomain.presentationlayer;


import com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer.PaymentType;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseRequestModel {
    String furnitureId;
    String customerId;
    String deliveryId;
    PaymentType paymentType;
    LocalDate purchaseDate;
    Status status;
}
