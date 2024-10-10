package com.panaritis.customersservice.customermanagementsubdomain.datamapperlayer;

import com.panaritis.customersservice.customermanagementsubdomain.presentationlayer.CustomerController;
import com.panaritis.customersservice.customermanagementsubdomain.datalayer.Customer;
import com.panaritis.customersservice.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {

    @Mapping(expression = "java(customer.getCustomerIdentifier().getCustomerId())", target = "customerId")
    @Mapping(expression = "java(customer.getAddress().getStreetAddress())", target = "streetAddress")
    @Mapping(expression = "java(customer.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(customer.getAddress().getProvince())", target = "province")
    @Mapping(expression = "java(customer.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(customer.getAddress().getPostalCode())", target = "postalCode")
    CustomerResponseModel entityToResponseModel(Customer customer);

    List<CustomerResponseModel> entityListToResponseModelList(List<Customer> customers);

    @AfterMapping
    default void addLinks(@MappingTarget CustomerResponseModel customerResponseModel, Customer customer){
        Link customerLink =
                WebMvcLinkBuilder.linkTo(methodOn(CustomerController.class).getCustomerByCustomerId(customerResponseModel
                        .getCustomerId())).withSelfRel();
        customerResponseModel.add(customerLink);

        Link allCustomersLink =
                linkTo(methodOn(CustomerController.class)
                        .getCustomers())
                        .withRel("allCustomer");
        customerResponseModel.add(allCustomersLink);
    }
}
