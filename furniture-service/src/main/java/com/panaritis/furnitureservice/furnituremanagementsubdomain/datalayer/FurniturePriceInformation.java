package com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class FurniturePriceInformation {

//    @Enumerated(EnumType.STRING)
//    private CurrencyType currencyType;

    private Double furnitureCost;

    public FurniturePriceInformation( @NotNull Double furnitureCost) {
//        this.currencyType = currencyType;
        this.furnitureCost = furnitureCost;
    }

}
