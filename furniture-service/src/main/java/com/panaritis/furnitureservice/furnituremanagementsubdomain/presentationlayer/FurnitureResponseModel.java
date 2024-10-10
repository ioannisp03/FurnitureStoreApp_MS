package com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer;

import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.CurrencyType;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.FurnitureCondition;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class FurnitureResponseModel extends RepresentationModel<FurnitureResponseModel> {
    String furnitureId;
    String furnitureName;
    Double furnitureCost;
    CurrencyType currencyType;
    String category;
    String description;
    String manufacturerName;
    String country;
    FurnitureCondition furnitureCondition;
}
