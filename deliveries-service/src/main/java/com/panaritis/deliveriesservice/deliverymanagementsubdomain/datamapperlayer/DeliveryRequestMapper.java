package com.panaritis.deliveriesservice.deliverymanagementsubdomain.datamapperlayer;


import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer.Delivery;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer.DeliveryIdentifier;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer.TransportDetails;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer.DeliveryRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
//            @Mapping(target = "customer", source = "deliveryRequestModel.customer")
    })
    Delivery requestModelToEntity(DeliveryRequestModel deliveryRequestModel, DeliveryIdentifier deliveryIdentifier, TransportDetails transportDetails);
}
