package com.panaritis.apigateway.presentationlayer.deliverydto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
