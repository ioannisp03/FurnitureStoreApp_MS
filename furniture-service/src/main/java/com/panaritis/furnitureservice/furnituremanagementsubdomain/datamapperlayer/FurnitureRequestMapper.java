package com.panaritis.furnitureservice.furnituremanagementsubdomain.datamapperlayer;



import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.Furniture;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.FurnitureIdentifier;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.FurniturePriceInformation;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.Manufacturer;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer.FurnitureRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FurnitureRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    Furniture requestModelToEntity(FurnitureRequestModel furnitureRequestModel, FurnitureIdentifier furnitureIdentifier, Manufacturer manufacturer, FurniturePriceInformation furniturePriceInformation);
}
