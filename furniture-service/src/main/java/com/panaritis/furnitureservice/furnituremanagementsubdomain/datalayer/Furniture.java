package com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "furniture")
@NoArgsConstructor
@Data
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //private identifier

    @Embedded
    private FurnitureIdentifier furnitureIdentifier;

    @Embedded
    private Manufacturer manufacturer;

    private String furnitureName;
    private String description;
    private String category;

    @Embedded
    private FurniturePriceInformation furniturePriceInformation;

    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @Column(name = "furniture_condition")
    @Enumerated(EnumType.STRING)
    private FurnitureCondition furnitureCondition;


    public Furniture(@NotNull CurrencyType currencyType,@NotNull FurniturePriceInformation furniturePriceInformation, @NotNull Manufacturer manufacturer, @NotNull String furnitureName,
                     @NotNull String description, @NotNull String category, @NotNull FurnitureCondition furnitureCondition) {
        this.furnitureIdentifier = new FurnitureIdentifier();
        this.manufacturer = manufacturer;
        this.furnitureName = furnitureName;
        this.description = description;
        this.category = category;
        this.furnitureCondition = furnitureCondition;
        this.furniturePriceInformation = furniturePriceInformation;
        this.currencyType = currencyType;

    }


}
