package com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DeliveryResponseModel extends RepresentationModel<DeliveryResponseModel> {
     String deliveryId;
     String firstName;
     String lastName;
     String address;
     String warehouseLocation;
     LocalDate deliveryDate;
     String eta;
     String shippingNumber;
     String email;
}
