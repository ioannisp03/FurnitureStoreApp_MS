package com.panaritis.customersservice.customermanagementsubdomain.datamapperlayer;

import com.panaritis.customersservice.customermanagementsubdomain.datalayer.Address;
import com.panaritis.customersservice.customermanagementsubdomain.datalayer.Customer;
import com.panaritis.customersservice.customermanagementsubdomain.datalayer.CustomerIdentifier;
import com.panaritis.customersservice.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import org.mapstruct.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    Customer requestModelToEntity(CustomerRequestModel customerRequestModel, CustomerIdentifier customerIdentifier,
                                  Address address);



}
