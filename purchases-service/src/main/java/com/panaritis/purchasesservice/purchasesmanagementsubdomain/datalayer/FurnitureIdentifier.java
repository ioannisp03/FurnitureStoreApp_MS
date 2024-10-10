package com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class FurnitureIdentifier {
    private String furnitureId;

    public FurnitureIdentifier(){
        this.furnitureId = UUID.randomUUID().toString();
    }
    public FurnitureIdentifier(String furnitureId){
        this.furnitureId = furnitureId;
    }
}
