package com.panaritis.apigateway.presentationlayer.customerdtos;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class CustomerResponseModel extends RepresentationModel<CustomerResponseModel> {
    String customerId;
    String customerFirstName;
    String customerLastName;
    String emailAddress;
    String streetAddress;
    String city;
    String province;
    String country;
    String postalCode;
}
