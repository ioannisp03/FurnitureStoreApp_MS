package com.panaritis.apigateway.datamapperlayer.purchasemappers;

import com.panaritis.apigateway.presentationlayer.CustomerPurchaseController;
import com.panaritis.apigateway.presentationlayer.FurnitureController;
import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureResponseModel;
import com.panaritis.apigateway.presentationlayer.purchasedto.PurchaseResponseModel;
//import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
//import org.mapstruct.MappingTarget;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true) )

public interface PurchaseResponseMapper {
    List<PurchaseResponseModel> responseModelToResponseModelList(List<PurchaseResponseModel> purchaseResponseModels);



    @AfterMapping
    default void addLinks(@MappingTarget PurchaseResponseModel purchaseResponseModel) {
        // Add self link to the response model
        Link selfLink = linkTo(methodOn(CustomerPurchaseController.class)
                .getPurchaseForCustomerByPurchaseId(purchaseResponseModel.getCustomerId(),
                        purchaseResponseModel.getPurchaseId()))
                .withSelfRel();
        purchaseResponseModel.add(selfLink);

        // Add all purchases for member link to the response model
        Link purchasesLink = linkTo(methodOn(CustomerPurchaseController.class)
                .getAllPurchasesForCustomer(purchaseResponseModel.getCustomerId()))
                .withRel("allPurchases");
        purchaseResponseModel.add(purchasesLink);


    }


}
