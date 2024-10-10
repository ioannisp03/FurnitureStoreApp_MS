package com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.deliveries;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class TransportDetails {
    private String warehouseLocation;
    private LocalDate deliveryDate;
    private String eta;
    private String shippingNumber;


    public TransportDetails(@NotNull String warehouseLocation, @NotNull LocalDate deliveryDate, @NotNull String eta, @NotNull String shippingNumber) {
        this.warehouseLocation = warehouseLocation;
        this.deliveryDate = deliveryDate;
        this.eta = eta;
        this.shippingNumber = shippingNumber;
    }

    public @NotNull String getWarehouseLocation() {
        return warehouseLocation;
    }

    public @NotNull LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public @NotNull String getETA() {
        return eta;
    }

    public @NotNull String getShippingNumber() {
        return shippingNumber;
    }
}
