package com.panaritis.furnitureservice.furnituremanagementsubdomain.businesslayer;


import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.*;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.datamapperlayer.FurnitureRequestMapper;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.datamapperlayer.FurnitureResponseMapper;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer.FurnitureRequestModel;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer.FurnitureResponseModel;


import com.panaritis.furnitureservice.furnituremanagementsubdomain.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FurnitureServiceImpl implements FurnitureService {


    private final FurnitureRepository furnitureRepository;
    private final FurnitureResponseMapper furnitureResponseMapper;
    private final FurnitureRequestMapper furnitureRequestMapper;

    public FurnitureServiceImpl(FurnitureRepository furnitureRepository, FurnitureResponseMapper furnitureResponseMapper, FurnitureRequestMapper furnitureRequestMapper) {
        this.furnitureRepository = furnitureRepository;
        this.furnitureResponseMapper = furnitureResponseMapper;
        this.furnitureRequestMapper = furnitureRequestMapper;
    }


    @Override
    public List<FurnitureResponseModel> getFurniture() {
        List<Furniture> furniture = furnitureRepository.findAll();
        return furnitureResponseMapper.entityListToResponseModelList(furniture);

    }

    @Override
    public FurnitureResponseModel getFurnitureByFurnitureId(String furnitureId) {
        Furniture furniture = furnitureRepository.findByFurnitureIdentifier_FurnitureId(furnitureId);

        if (furniture == null) {
            throw new NotFoundException("Unknown furnitureId " + furnitureId);
        }
        return furnitureResponseMapper.entityToResponseModel(furniture);
    }

    @Override
    public FurnitureResponseModel addFurniture(FurnitureRequestModel furnitureRequestModel) {
        Manufacturer manufacturer = new Manufacturer(furnitureRequestModel.getManufacturerName(), furnitureRequestModel.getCountry());

        Furniture furniture = furnitureRequestMapper.requestModelToEntity(furnitureRequestModel, new FurnitureIdentifier(), manufacturer, new FurniturePriceInformation(furnitureRequestModel.getFurnitureCost()));

        furniture.setManufacturer(manufacturer);
        return furnitureResponseMapper.entityToResponseModel(furnitureRepository.save(furniture));

    }

    @Override
    public FurnitureResponseModel updateFurniture(String furnitureId, FurnitureRequestModel furnitureRequestModel) {
        Furniture existingFurniture = furnitureRepository.findByFurnitureIdentifier_FurnitureId(furnitureId);
        if (existingFurniture == null) {
            throw new NotFoundException("Unknown furnitureId " + furnitureId);
        }
        Manufacturer manufacturer = new Manufacturer(furnitureRequestModel.getManufacturerName(), furnitureRequestModel.getCountry());
        Furniture updatedFurniture = furnitureRequestMapper.requestModelToEntity(furnitureRequestModel, existingFurniture.getFurnitureIdentifier(), manufacturer, new FurniturePriceInformation(furnitureRequestModel.getFurnitureCost()));
        updatedFurniture.setId(existingFurniture.getId());
        Furniture response = furnitureRepository.save(updatedFurniture);


        return furnitureResponseMapper.entityToResponseModel(furnitureRepository.save(response));
    }

    @Override
    public void removeFurniture(String furnitureId) {
        Furniture existingFurniture = furnitureRepository.findByFurnitureIdentifier_FurnitureId(furnitureId);
        if (existingFurniture == null) {
            throw new NotFoundException("Unknown furnitureId " + furnitureId);
        }

        furnitureRepository.delete(existingFurniture);
    }
}
