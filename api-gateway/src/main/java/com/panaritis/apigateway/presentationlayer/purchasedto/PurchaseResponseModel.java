package com.panaritis.apigateway.presentationlayer.purchasedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PurchaseResponseModel extends RepresentationModel<PurchaseResponseModel> {
    private String purchaseId;
//    private PaymentType paymentType;
    private LocalDate purchaseDate;
//    private Status status;

    private String customerId;
    private String customerFirstName;
    private String customerLastName;
//    private String address;
//    private String email;

    private String furnitureId;
    private String furnitureName;
    private Double furnitureCost;
//    private CurrencyType currencyType;
    //    private String description;
//    private String category;
//    private FurnitureCondition furnitureCondition;
    //    private String manufacturerName;
    private String country;

    private String deliveryId;
    private String shippingNumber;
    private String warehouseLocation;
    private String deliveryDate;
    private String eta;
}
