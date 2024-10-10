package com.panaritis.furnitureservice.furnituremanagementsubdomain.businesslayer;

import com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer.FurnitureRequestModel;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer.FurnitureResponseModel;

import java.util.List;

public interface FurnitureService {

    List<FurnitureResponseModel> getFurniture();

    FurnitureResponseModel getFurnitureByFurnitureId(String furnitureId);

    FurnitureResponseModel addFurniture(FurnitureRequestModel furnitureRequestModel);

    FurnitureResponseModel updateFurniture(String furnitureId, FurnitureRequestModel furnitureRequestModel);

    void removeFurniture (String furnitureId);







}
