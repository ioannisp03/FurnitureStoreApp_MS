package com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class SalesIdentifier {

    private String salesId;

    public SalesIdentifier(){
        this.salesId = UUID.randomUUID().toString();
    }
    public SalesIdentifier(String salesId){
        this.salesId = salesId;
    }
}
