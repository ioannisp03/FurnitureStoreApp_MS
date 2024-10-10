package com.panaritis.purchasesservice.purchasesmanagementsubdomain.presentationlayer;


import com.panaritis.purchasesservice.purchasesmanagementsubdomain.businesslayer.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers/{customerId}/purchases")
public class CustomerPurchaseController {
    private PurchaseService purchaseService;

    public CustomerPurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }


    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PurchaseResponseModel>> getAllPurchasesForCustomer(@PathVariable String customerId) {
        return ResponseEntity.ok().body(purchaseService.getAllPurchasesForCustomer(customerId));
    }

    @GetMapping(value = "/{purchaseId}", produces = "application/json")
    public ResponseEntity<PurchaseResponseModel> getPurchaseForCustomerByPurchaseId(@PathVariable String customerId, @PathVariable String purchaseId) {
        return ResponseEntity.ok().body(purchaseService.getCustomerPurchaseByPurchaseId(customerId, purchaseId));
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PurchaseResponseModel> addPurchaseToCustomer(@RequestBody PurchaseRequestModel purchaseRequestModel, @PathVariable String customerId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.addPurchaseToCustomer(purchaseRequestModel, customerId));
    }

    @PutMapping(value = "/{purchaseId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PurchaseResponseModel> updateCustomerPurchase(@RequestBody PurchaseRequestModel purchaseRequestModel, @PathVariable String customerId, @PathVariable String purchaseId) {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.updateCustomerPurchase(purchaseRequestModel, customerId, purchaseId));
    }

    @DeleteMapping(value = "/{purchaseId}")
    public ResponseEntity<Void> removePurchaseFromCustomer(@PathVariable String customerId, @PathVariable String purchaseId) {
        purchaseService.removePurchaseFromCustomer(customerId, purchaseId);
        return ResponseEntity.noContent().build();
    }
}
