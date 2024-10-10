package com.panaritis.apigateway.presentationlayer.furnituredtos;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class FurnitureResponseModel extends RepresentationModel<FurnitureResponseModel> {

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
