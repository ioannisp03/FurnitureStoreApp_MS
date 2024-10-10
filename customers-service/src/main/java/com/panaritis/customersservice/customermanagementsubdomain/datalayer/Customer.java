package com.panaritis.customersservice.customermanagementsubdomain.datalayer;

//import com.panaritis.furniturestoreapp.common.CustomerIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //private identifier

    @Embedded
    private CustomerIdentifier customerIdentifier; //public identifier

    private String customerFirstName;
    private String customerLastName;
    private String emailAddress;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "customer_phonenumbers", joinColumns = @JoinColumn(name="customer_id"))
    private List<PhoneNumber> phoneNumbers;

    public Customer(@NotNull String customerFirstName, @NotNull String customerLastName, @NotNull String emailAddress, @NotNull Address address,
                    @NotNull List<PhoneNumber> phoneNumberList) {
        this.customerIdentifier = new CustomerIdentifier();
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumbers = phoneNumberList;
    }


}
