package com.panaritis.purchasesservice.purchasesmanagementsubdomain.datamapperlayer;


import com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer.Purchase;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.presentationlayer.CustomerPurchaseController;
//import com.panaritis.customersservice.customermanagementsubdomain.presentationlayer.CustomerController; ??
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.presentationlayer.PurchaseResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")

public interface PurchaseResponseMapper {


    @Mapping(expression = "java(purchase.getPurchaseIdentifier().getPurchaseId())", target = "purchaseId")

    @Mapping(expression = "java(purchase.getPaymentType())", target = "paymentType")
    @Mapping(expression = "java(purchase.getPurchaseDate())", target = "purchaseDate")
    @Mapping(expression = "java(purchase.getStatus())", target = "status")


    @Mapping(expression = "java(purchase.getCustomerModel().getCustomerId())", target = "customerId")
    @Mapping(expression = "java(purchase.getCustomerModel().getCustomerFirstName())", target = "customerFirstName")
    @Mapping(expression = "java(purchase.getCustomerModel().getCustomerLastName())", target = "customerLastName")

    @Mapping(expression = "java(purchase.getFurnitureModel().getFurnitureId())", target = "furnitureId")
    @Mapping(expression = "java(purchase.getFurnitureModel().getFurnitureName())", target = "furnitureName")
    @Mapping(expression = "java(purchase.getFurnitureModel().getFurnitureCost())", target = "furnitureCost")
    @Mapping(expression = "java(purchase.getFurnitureModel().getCurrencyType())", target = "currencyType")
    @Mapping(expression = "java(purchase.getFurnitureModel().getFurnitureCondition())", target = "furnitureCondition")
    @Mapping(expression = "java(purchase.getFurnitureModel().getCountry())", target = "country")


    @Mapping(expression = "java(purchase.getDeliveryModel().getDeliveryId())", target = "deliveryId")
    @Mapping(expression = "java(purchase.getDeliveryModel().getShippingNumber())", target = "shippingNumber")
    @Mapping(expression = "java(purchase.getDeliveryModel().getWarehouseLocation())", target = "warehouseLocation")
    @Mapping(expression = "java(purchase.getDeliveryModel().getDeliveryDate().toString())", target = "deliveryDate")
    @Mapping(expression = "java(purchase.getDeliveryModel().getEta())", target = "eta")
    PurchaseResponseModel entityToResponseModel(Purchase purchase);

    List<PurchaseResponseModel> entityToResponseModelList(List<Purchase> purchaseList);


//    @AfterMapping
//    default void addLinks(@MappingTarget PurchaseResponseModel purchaseResponseModel) {
//
////        Purchase link
//        Link purchaseLink =
//                linkTo(methodOn(CustomerPurchaseController.class).getPurchaseForCustomerByPurchaseId(purchaseResponseModel.getCustomerId(),purchaseResponseModel.getPurchaseId())).withSelfRel();
//        purchaseResponseModel.add(purchaseLink);
//
//
//        Link allPurchasesLink =
//                linkTo(methodOn(CustomerPurchaseController.class)
//                        .getAllPurchasesForCustomer(purchaseResponseModel.getCustomerId()))
//                        .withRel("allPurchases").withRel("Purchases");
//        purchaseResponseModel.add(allPurchasesLink);
//
//
////        Customer link
//        Link customerLink =
//                linkTo(methodOn(CustomerController.class).getCustomerByCustomerId(purchaseResponseModel
//                        .getCustomerId())).withSelfRel().withRel("Customers");
//        purchaseResponseModel.add(customerLink);
//
//
////        Deliveries link
//        Link deliveriesLink =
//                linkTo(methodOn(DeliveryController.class).getDeliveryByDeliveryId(purchaseResponseModel
//                        .getDeliveryId())).withSelfRel().withRel("Deliveries");
//        purchaseResponseModel.add(deliveriesLink);
//
//
//        Link furnitureLink =
//                linkTo(methodOn(FurnitureController.class).getFurnitureByFurnitureId(purchaseResponseModel
//                        .getFurnitureId())).withSelfRel().withRel("Furniture");
//        purchaseResponseModel.add(furnitureLink);
//
//
//    }
//

}