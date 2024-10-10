package com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode

public class Manufacturer {

    private String manufacturerName;
    private String country;

    public Manufacturer(@NotNull String manufacturerName, @NotNull String country) {
        this.manufacturerName = manufacturerName;
        this.country = country;
    }

    public @NotNull String getManufacturerName() {
        return manufacturerName;
    }

    public  @NotNull String getCountry() {
        return country;
    }
}
