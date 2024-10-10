package com.panaritis.apigateway.presentationlayer;

import com.panaritis.apigateway.businesslayer.furnitureservices.FurnitureService;
import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureRequestModel;
import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/furniture")
public class FurnitureController {

    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) { this.furnitureService = furnitureService; }

    @GetMapping
    public ResponseEntity<List<FurnitureResponseModel>> getFurniture() {
        return ResponseEntity.ok().body(furnitureService.getFurniture());
    }

    @GetMapping("/{furnitureId}")
    public ResponseEntity<FurnitureResponseModel> getFurnitureByFurnitureId(@PathVariable String furnitureId) {
        return ResponseEntity.ok().body(furnitureService.getFurnitureById(furnitureId));
    }

    @PostMapping
    public ResponseEntity<FurnitureResponseModel> addCustomer(@RequestBody FurnitureRequestModel furnitureRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(furnitureService.addFurniture(furnitureRequestModel));
    }

    @PutMapping("/{furnitureId}")
    public ResponseEntity<FurnitureResponseModel> updateFurniture(@RequestBody FurnitureRequestModel furnitureRequestModel,
                                                                  @PathVariable String furnitureId) {
        furnitureService.updateFurniture(furnitureId, furnitureRequestModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{furnitureId}")
    public ResponseEntity<Void> deleteFurniture(@PathVariable String furnitureId) {
        furnitureService.removeFurniture(furnitureId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

