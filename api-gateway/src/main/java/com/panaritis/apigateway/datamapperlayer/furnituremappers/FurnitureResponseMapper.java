package com.panaritis.apigateway.datamapperlayer.furnituremappers;

import com.panaritis.apigateway.presentationlayer.FurnitureController;
import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true) )
public interface FurnitureResponseMapper {

    FurnitureResponseModel responseModelToResponseModel(FurnitureResponseModel furnitureResponseModel);

    List<FurnitureResponseModel> responseModelToResponseModelList(List<FurnitureResponseModel> furnitureResponseModels);

    @AfterMapping
    default void afterMapping(@MappingTarget FurnitureResponseModel furnitureResponseModel){

        Link selfLink = linkTo(methodOn(FurnitureController.class)
                .getFurnitureByFurnitureId(furnitureResponseModel.getFurnitureId()))
                .withSelfRel();

        furnitureResponseModel.add(selfLink);

        Link allLink = linkTo(methodOn(FurnitureController.class)
                .getFurniture())
                .withRel("ALL FURNITURE");

        furnitureResponseModel.add(allLink);
    }




}
