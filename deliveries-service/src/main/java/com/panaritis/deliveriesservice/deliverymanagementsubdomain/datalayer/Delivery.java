package com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "delivery")
@Data
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;

    private String address;
    private String email;

    @Embedded
    private DeliveryIdentifier deliveryIdentifier;

    @Embedded
    private TransportDetails transportDetails;

//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

//    public Delivery(@NotNull String name, @NotNull String address, @NotNull TransportDetails transportDetails) {
//        this.deliveryIdentifier = new DeliveryIdentifier();
//        this.name = name;
//        this.address = address;
//        this.transportDetails = transportDetails;
//    }
    public Delivery(@NotNull String firstName,@NotNull String lastName, @NotNull String address, @NotNull String email,@NotNull DeliveryIdentifier deliveryIdentifier,
                    @NotNull TransportDetails transportDetails) {
        this.deliveryIdentifier = new DeliveryIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.transportDetails = transportDetails;
    }

}
