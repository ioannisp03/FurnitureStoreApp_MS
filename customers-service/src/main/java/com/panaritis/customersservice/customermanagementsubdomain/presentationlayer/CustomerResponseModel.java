package com.panaritis.customersservice.customermanagementsubdomain.presentationlayer;

import com.panaritis.customersservice.customermanagementsubdomain.datalayer.PhoneNumber;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public final class CustomerResponseModel extends RepresentationModel<CustomerResponseModel> {

    String customerId;
    String customerFirstName;
    String customerLastName;
    String emailAddress;
    String streetAddress;
    String city;
    String province;
    String country;
    String postalCode;
    List<PhoneNumber> phoneNumbers;

}
