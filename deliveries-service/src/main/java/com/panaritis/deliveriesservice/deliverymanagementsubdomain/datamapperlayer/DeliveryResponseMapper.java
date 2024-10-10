package com.panaritis.deliveriesservice.deliverymanagementsubdomain.datamapperlayer;


import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer.Delivery;

import com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer.DeliveryController;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer.DeliveryResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface DeliveryResponseMapper {

    @Mapping(expression = "java(delivery.getDeliveryIdentifier().getDeliveryId())", target = "deliveryId")
    @Mapping(expression = "java(delivery.getFirstName())", target = "firstName")
    @Mapping(expression = "java(delivery.getLastName())", target = "lastName")

    @Mapping(expression = "java(delivery.getAddress())", target = "address")
    @Mapping(expression = "java(delivery.getEmail())", target = "email")
    @Mapping(expression = "java(delivery.getTransportDetails().getWarehouseLocation())", target = "warehouseLocation")
    @Mapping(expression = "java(delivery.getTransportDetails().getDeliveryDate())", target = "deliveryDate")
    @Mapping(expression = "java(delivery.getTransportDetails().getShippingNumber())", target = "shippingNumber")
    @Mapping(expression = "java(delivery.getTransportDetails().getETA())", target = "eta")
    DeliveryResponseModel entityToResponseModel(Delivery delivery);

    List<DeliveryResponseModel> entityToResponseModelList(List<Delivery> deliveries);

    @AfterMapping
    default void addLinks(@MappingTarget DeliveryResponseModel deliveryResponseModel, Delivery delivery){
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
