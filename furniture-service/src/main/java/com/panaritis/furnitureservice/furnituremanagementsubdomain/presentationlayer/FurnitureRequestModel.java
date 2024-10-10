package com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer;


import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.CurrencyType;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.FurnitureCondition;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FurnitureRequestModel {

//    String furnitureId;
    Double furnitureCost;
    CurrencyType currencyType;
    String manufacturerName;
    String country;
    String furnitureName;
    String description;
    String category;
    FurnitureCondition furnitureCondition;


}
