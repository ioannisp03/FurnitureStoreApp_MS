package com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.deliveries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@Embeddable
public class DeliveryModel {
    String deliveryId;
    String warehouseLocation;
    LocalDate deliveryDate;
    String eta;
    String shippingNumber;

    public DeliveryModel(String deliveryId, String warehouseLocation, LocalDate deliveryDate, String eta, String shippingNumber) {
        this.deliveryId = deliveryId;
        this.warehouseLocation = warehouseLocation;
        this.deliveryDate = deliveryDate;
        this.eta = eta;
        this.shippingNumber = shippingNumber;
    }

    public DeliveryModel() {

    }
}
