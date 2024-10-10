package com.panaritis.apigateway.presentationlayer.furnituredtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FurnitureRequestModel {

    String furnitureId;
    String furnitureName;
    Double furnitureCost;
//    CurrencyType currencyType;
    String category;
    String description;
    String manufacturerName;
    String country;
//    FurnitureCondition furnitureCondition;
}
