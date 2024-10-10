package com.panaritis.apigateway.presentationlayer.purchasedto;

import java.time.LocalDate;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
@lombok.EqualsAndHashCode(callSuper = false)
public class PurchaseRequestModel {

    String furnitureId;
    String customerId;
    String deliveryId;
//    PaymentType paymentType;
    LocalDate purchaseDate;
//    Status status;






}
