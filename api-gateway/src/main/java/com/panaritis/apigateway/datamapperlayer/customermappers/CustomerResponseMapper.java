package com.panaritis.apigateway.datamapperlayer.customermappers;
import com.panaritis.apigateway.presentationlayer.CustomerController;
import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomerResponseMapper {


    CustomerResponseModel responseModelToResponseModel(CustomerResponseModel customerResponseModel);

    List<CustomerResponseModel> responseModelToResponseModelList(List<CustomerResponseModel> customerResponseModel);

    @AfterMapping
    default void afterMapping(@MappingTarget CustomerResponseModel customerResponseModel) {

        Link selfLink = linkTo(methodOn(CustomerController.class)
                .getCustomerById(customerResponseModel.getCustomerId()))
                .withSelfRel();

        customerResponseModel.add(selfLink);

        Link allLink = linkTo(methodOn(CustomerController.class)
                .getCustomers())
                .withRel("All Cusomters");

        customerResponseModel.add(allLink);
    }
}
