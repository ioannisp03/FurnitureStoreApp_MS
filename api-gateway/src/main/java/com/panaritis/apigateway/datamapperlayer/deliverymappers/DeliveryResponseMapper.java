package com.panaritis.apigateway.datamapperlayer.deliverymappers;

import com.panaritis.apigateway.presentationlayer.DeliveryController;
import com.panaritis.apigateway.presentationlayer.deliverydto.DeliveryResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface DeliveryResponseMapper {


    DeliveryResponseModel entityToResponseModel(DeliveryResponseMapper deliveryResponseMapper);

    List<DeliveryResponseModel> entityToResponseModelList(List<DeliveryResponseModel> deliveries);

    @AfterMapping
    default void addLinks(@MappingTarget DeliveryResponseModel deliveryResponseModel){
        Link selfLink =
                linkTo(methodOn(DeliveryController.class).getDeliveryByDeliveryId(deliveryResponseModel
                        .getDeliveryId())).withSelfRel();
        deliveryResponseModel.add(selfLink);

        Link allDeliveriesLink =
                linkTo(methodOn(DeliveryController.class)
                        .getDeliveries())
                        .withRel("allDeliveries");
        deliveryResponseModel.add(allDeliveriesLink);
    }
}





