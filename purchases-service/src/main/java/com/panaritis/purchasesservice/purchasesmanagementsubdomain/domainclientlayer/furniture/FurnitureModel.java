package com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.furniture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer.CurrencyType;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@Embeddable
public class FurnitureModel {
    String furnitureId;
    String furnitureName;
    Double furnitureCost;
    CurrencyType currencyType;

    String country;
    FurnitureCondition furnitureCondition;


    public FurnitureModel(String furnitureId, String furnitureName, Double furnitureCost, CurrencyType currencyType, String country, FurnitureCondition furnitureCondition) {
        this.furnitureId = furnitureId;
        this.furnitureName = furnitureName;
        this.furnitureCost = furnitureCost;
        this.currencyType = currencyType;
        this.country = country;
        this.furnitureCondition = furnitureCondition;
    }

    public FurnitureModel() {

    }
}