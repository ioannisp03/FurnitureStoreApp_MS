package com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.customers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@Embeddable
public final class CustomerModel {
    String customerId;
    String customerFirstName;
    String customerLastName;

    public CustomerModel(String customerId, String customerFirstName, String customerLastName) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
    }

    public CustomerModel() {

    }

}
