package com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer;

import com.panaritis.deliveriesservice.deliverymanagementsubdomain.businesslayer.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping()
    public ResponseEntity<List<DeliveryResponseModel>> getDeliveries() {
        List<DeliveryResponseModel> deliveries = deliveryService.getDeliveries();
        return ResponseEntity.status(HttpStatus.OK).body(deliveries);
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryResponseModel> getDeliveryByDeliveryId(@PathVariable String deliveryId) {
        DeliveryResponseModel delivery = deliveryService.getDeliveriesByDeliveryId(deliveryId);
        return ResponseEntity.status(HttpStatus.OK).body(delivery);
    }

    @PostMapping()
    public ResponseEntity<DeliveryResponseModel> addDelivery(@RequestBody DeliveryRequestModel deliveryRequestModel) {
        DeliveryResponseModel createdDelivery = deliveryService.addDelivery(deliveryRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDelivery);
    }

    @PutMapping("/{deliveryId}")
    public ResponseEntity<DeliveryResponseModel> updateDelivery(@RequestBody DeliveryRequestModel deliveryRequestModel,
                                                                @PathVariable String deliveryId) {
        DeliveryResponseModel updatedDelivery = deliveryService.updateDelivery(deliveryRequestModel, deliveryId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDelivery);
    }

    @DeleteMapping("/{deliveryId}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable String deliveryId) {
        deliveryService.removeDelivery(deliveryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
