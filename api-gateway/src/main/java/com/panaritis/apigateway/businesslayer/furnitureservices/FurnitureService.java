package com.panaritis.apigateway.businesslayer.furnitureservices;

import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureRequestModel;
import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;
public interface FurnitureService {

    List<FurnitureResponseModel> getFurniture();
    FurnitureResponseModel getFurnitureById(String customerId);
    FurnitureResponseModel addFurniture(FurnitureRequestModel FurnitureRequestModel);
    void updateFurniture(String furnitureId, FurnitureRequestModel FurnitureRequestModel);
    void removeFurniture(String furnitureId);
}
