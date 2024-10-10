package com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer;


import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.customers.CustomerModel;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.deliveries.DeliveryModel;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.deliveries.TransportDetails;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.furniture.FurnitureModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "purchase")
@Data
@NoArgsConstructor
@Builder
//@AllArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    PurchaseIdentifier purchaseIdentifier;

    @Embedded
    private CustomerModel customerModel;

    @Embedded
    private DeliveryModel deliveryModel;

    @Embedded
    private FurnitureModel furnitureModel;
    private LocalDate purchaseDate;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    // invariant. Sets purchase status to canceled when purchase deleted.
    @Enumerated(EnumType.STRING)
    private Status status;

//    @Embedded
//    private TransportDetails transportDetails;


    public Purchase(Integer id, PurchaseIdentifier purchaseIdentifier, CustomerModel customerModel,
                    DeliveryModel deliveryModel, FurnitureModel furnitureModel, LocalDate purchaseDate,
                    PaymentType paymentType, Status status) {
        this.id = id;
        this.purchaseIdentifier = new PurchaseIdentifier();
        this.customerModel = customerModel;
        this.deliveryModel = deliveryModel;
        this.furnitureModel = furnitureModel;
        this.purchaseDate = purchaseDate;
        this.paymentType = paymentType;
        this.status = status;
    }
}
