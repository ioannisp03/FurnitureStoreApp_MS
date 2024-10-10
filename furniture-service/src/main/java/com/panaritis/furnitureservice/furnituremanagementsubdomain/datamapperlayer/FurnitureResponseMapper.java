package com.panaritis.furnitureservice.furnituremanagementsubdomain.datamapperlayer;

import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.Furniture;

import com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer.FurnitureController;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer.FurnitureResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface FurnitureResponseMapper {
    @Mapping(expression = "java(furniture.getFurnitureIdentifier().getFurnitureId())", target = "furnitureId")
    @Mapping(expression = "java(furniture.getManufacturer().getManufacturerName())", target = "manufacturerName")
    @Mapping(expression = "java(furniture.getManufacturer().getCountry())", target = "country")
    @Mapping(expression = "java(furniture.getFurnitureName())", target = "furnitureName")
    @Mapping(expression = "java(furniture.getDescription())", target = "description")
    @Mapping(expression = "java(furniture.getCategory())", target = "category")
    @Mapping(expression = "java(furniture.getFurnitureCondition())", target = "furnitureCondition")
    @Mapping(expression = "java(furniture.getCurrencyType())", target = "currencyType")
    @Mapping(expression = "java(furniture.getFurniturePriceInformation().getFurnitureCost())", target = "furnitureCost")
    FurnitureResponseModel entityToResponseModel(Furniture furniture);
    List<FurnitureResponseModel> entityListToResponseModelList(List<Furniture> furnitureList);

    @AfterMapping
    default void addLinks(@MappingTarget FurnitureResponseModel furnitureResponseModel, Furniture furniture){
        Link selfLink =
                linkTo(methodOn(FurnitureController.class).getFurnitureByFurnitureId(furnitureResponseModel
                        .getFurnitureId())).withSelfRel();
        furnitureResponseModel.add(selfLink);

        Link allFurnitureLink =
                linkTo(methodOn(FurnitureController.class)
                        .getFurniture())
                        .withRel("allFurniture");
        furnitureResponseModel.add(allFurnitureLink);
    }
}
