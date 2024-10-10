package com.panaritis.apigateway.businesslayer.furnitureservices;

import com.panaritis.apigateway.datamapperlayer.furnituremappers.FurnitureResponseMapper;
import com.panaritis.apigateway.domainclientlayer.FurnitureServiceClient;
import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureRequestModel;
import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FurnitureServiceImpl implements FurnitureService {

    private final FurnitureServiceClient furnitureServiceClient;
    private final FurnitureResponseMapper furnitureResponseMapper;


    public FurnitureServiceImpl(FurnitureServiceClient furnitureServiceClient, FurnitureResponseMapper furnitureResponseMapper) {
        this.furnitureServiceClient = furnitureServiceClient;
        this.furnitureResponseMapper = furnitureResponseMapper;
    }

    @Override
    public List<FurnitureResponseModel> getFurniture() {
        return furnitureResponseMapper.responseModelToResponseModelList(furnitureServiceClient.getFurniture());
    }

    @Override
    public FurnitureResponseModel getFurnitureById(String furnitureId) {
        return furnitureResponseMapper.responseModelToResponseModel(furnitureServiceClient.getFurnitureByFurnitureId(furnitureId));
    }

    @Override
    public FurnitureResponseModel addFurniture(FurnitureRequestModel furnitureRequestModel) {
        return furnitureResponseMapper.responseModelToResponseModel(furnitureServiceClient.addFurniture(furnitureRequestModel));
    }

    @Override
    public void updateFurniture(String furnitureId, FurnitureRequestModel furnitureRequestModel) {
        furnitureServiceClient.updateFurniture(furnitureId, furnitureRequestModel);
    }

    @Override
    public void removeFurniture(String furnitureId) {
        furnitureServiceClient.deleteFurniture(furnitureId);
    }
}
