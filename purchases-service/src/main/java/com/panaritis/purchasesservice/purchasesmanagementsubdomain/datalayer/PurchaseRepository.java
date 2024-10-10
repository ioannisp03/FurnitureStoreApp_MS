package com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer;

import com.panaritis.purchasesservice.purchasesmanagementsubdomain.presentationlayer.PurchaseResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    List<Purchase> findPurchaseByCustomerModel_CustomerId(String customerId);

    Purchase findPurchaseByCustomerModel_CustomerIdAndPurchaseIdentifier_PurchaseId(String customerId, String purchaseId);

}
