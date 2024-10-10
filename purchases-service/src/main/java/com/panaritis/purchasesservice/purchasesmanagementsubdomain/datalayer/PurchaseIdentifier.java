package com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class PurchaseIdentifier {

    private String purchaseId;

    public PurchaseIdentifier() {
        this.purchaseId = java.util.UUID.randomUUID().toString();
    }
    public PurchaseIdentifier(String purchaseId) {
        this.purchaseId = purchaseId;
    }


}
