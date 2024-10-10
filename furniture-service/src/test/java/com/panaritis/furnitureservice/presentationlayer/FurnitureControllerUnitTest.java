package com.panaritis.furnitureservice.presentationlayer;


import com.panaritis.furnitureservice.furnituremanagementsubdomain.businesslayer.FurnitureService;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.CurrencyType;
//import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.Furniture;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.FurnitureCondition;
//import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.Manufacturer;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer.FurnitureController;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer.FurnitureRequestModel;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.presentationlayer.FurnitureResponseModel;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.utils.exceptions.InvalidInputException;
import com.panaritis.furnitureservice.furnituremanagementsubdomain.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = FurnitureController.class)
public class FurnitureControllerUnitTest {


    @MockBean
    FurnitureService furnitureService;

    @Autowired
    FurnitureController furnitureController;

    private final String VALID_FURNITURE_ID = "2b16459e-9d8a-4f85-8337-39ae0af871a1"; // Valid ID
    private final String NOT_FOUND_FURNITURE_ID = "Ab16459e-9d8a-4f85-8337-39ae0af871a1"; //very similar but wrong ID
    private final String INVALID_FURNITURE_ID = "0b16457e-9d8a-4f85-8337"; //very different ID




    @Test
    public void whenFurnitureExists_ReturnFurniture() {
        //arrange
        List<FurnitureResponseModel> furnitureResponseModelList = buildFurnitureResponseModel();

        //when we get furniture, there should be a list
        when(furnitureService.getFurniture()).thenReturn(furnitureResponseModelList);

        //act
        ResponseEntity<List<FurnitureResponseModel>> furnitureResponseEntity = furnitureController.getFurniture();

        //assert
        assertNotNull(furnitureResponseEntity);
        assertEquals(furnitureResponseEntity.getStatusCode(), HttpStatus.OK); //ensure successful request
        assertNotNull(furnitureResponseEntity.getBody()); //make sure body has data and not null
        assertEquals(furnitureResponseEntity.getBody().size(), 2);
        assertArrayEquals(furnitureResponseEntity.getBody().toArray(), furnitureResponseModelList.toArray());
        verify(furnitureService, times(1)).getFurniture();


    }

    public List<FurnitureResponseModel> buildFurnitureResponseModel() {

        FurnitureResponseModel furnitureResponseModel1 = FurnitureResponseModel.builder()
                .furnitureId(VALID_FURNITURE_ID)
                .furnitureName("IoannisCouch")
                .furnitureCost(2000.00)
                .currencyType(CurrencyType.CAD)
                .category("Couches")
                .description("Massive Couch")
                .manufacturerName("PanaritisLimited")
                .country("Canada")
                .furnitureCondition(FurnitureCondition.BRANDNEW)
                .build();

        FurnitureResponseModel furnitureResponseModel2 = FurnitureResponseModel.builder()
                .furnitureId("8f3c7d88-f1a2-44d7-b722-c9f1196019c1")
                .furnitureName("BoringCouch")
                .furnitureCost(2003.00)
                .currencyType(CurrencyType.USD)
                .category("Furniture")
                .description("Small Couch")
                .manufacturerName("PanLimited")
                .country("Canada")
                .furnitureCondition(FurnitureCondition.BRANDNEW)
                .build();


        List<FurnitureResponseModel> furnitureResponseModelList = new ArrayList<>();
        furnitureResponseModelList.add(furnitureResponseModel1);
        furnitureResponseModelList.add(furnitureResponseModel2);

        return furnitureResponseModelList;
    }

    @Test
    public void whenNoFurnitureExists_ReturnEmptyList() {

        //arrange (You mock when no furniture exists, return empty list)
        when(furnitureService.getFurniture()).thenReturn(Collections.emptyList());

        //act
        ResponseEntity<List<FurnitureResponseModel>> furnitureResponseEntity = furnitureController.getFurniture();

        //assertion
        assertNotNull(furnitureResponseEntity);
        assertEquals(furnitureResponseEntity.getStatusCode(), HttpStatus.OK);

        //compare the result (empty list) with an empty list
        assertArrayEquals(furnitureResponseEntity.getBody().toArray(),
                new ArrayList<FurnitureResponseModel>().toArray());

        //checks if method was only called once.
        verify(furnitureService, times(1)).getFurniture();


    }


    @Test
    public void whenFurnitureExists_thenDeleteFurniture() throws NotFoundException {
        // Arrange
        doNothing().when(furnitureService).removeFurniture(VALID_FURNITURE_ID); //doNothing used for void return types


        // Act
        ResponseEntity<Void> responseEntity = furnitureController.deleteFurniture(VALID_FURNITURE_ID);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(furnitureService, times(1)).removeFurniture(VALID_FURNITURE_ID);
    }

    @Test
    public void WhenFurnitureDoesNotExistOnDelete_thenReturnNotFoundException() throws NotFoundException {
        // Arrange
        doThrow(NotFoundException.class).when(furnitureService).removeFurniture(INVALID_FURNITURE_ID);

        // Act and Assert
        try {
            furnitureController.deleteFurniture(INVALID_FURNITURE_ID);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown once
            verify(furnitureService, times(1)).removeFurniture(INVALID_FURNITURE_ID);
        }
    }


    @Test
    public void whenFurnitureNotFoundOnGet_thenReturnNotFoundException() {
        // Arrange
        when(furnitureService.getFurnitureByFurnitureId(NOT_FOUND_FURNITURE_ID)).thenThrow(NotFoundException.class);

        // Act and Assert
        try {
            furnitureController.getFurnitureByFurnitureId(NOT_FOUND_FURNITURE_ID);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(furnitureService, times(1)).getFurnitureByFurnitureId(NOT_FOUND_FURNITURE_ID);
        }
    }

    //
    @Test
    public void whenFurnitureNotExistOnUpdate_thenReturnNotFoundException() throws NotFoundException {
        // Arrange
        FurnitureRequestModel updatedFurniture = FurnitureRequestModel.builder()
                .furnitureCost(200.00)
                .currencyType(CurrencyType.CAD)
                .manufacturerName("Manufacturer1")
                .country("Canada")
                .furnitureName("LoveCouch")
                .description("Lovely Couch")
                .category("Couches")
                .furnitureCondition(FurnitureCondition.BRANDNEW)
                .build();

        when(furnitureService.updateFurniture(NOT_FOUND_FURNITURE_ID, updatedFurniture)).thenThrow(NotFoundException.class);

        // Act and Assert
        try {
            furnitureController.updateFurniture(updatedFurniture, NOT_FOUND_FURNITURE_ID);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(furnitureService, times(1)).updateFurniture(NOT_FOUND_FURNITURE_ID, updatedFurniture);
        }
    }

    //
//
    @Test
    public void whenFurnitureExist_thenReturnUpdateFurniture() throws NotFoundException {
        // Arrange
//        String existingFurnitureId = VALID_FURNITURE_ID;
        FurnitureRequestModel updatedFurniture = FurnitureRequestModel.builder()
                .furnitureCost(200.00)
                .currencyType(CurrencyType.CAD)
                .manufacturerName("Manufacturer1")
                .country("Canada")
                .furnitureName("LoveCouch")
                .description("Lovely Couch")
                .category("Couches")
                .furnitureCondition(FurnitureCondition.BRANDNEW)
                .build();

        FurnitureResponseModel updatedResponse = FurnitureResponseModel.builder()
                .furnitureId(VALID_FURNITURE_ID)
                .build();

        when(furnitureService.updateFurniture(VALID_FURNITURE_ID, updatedFurniture)).thenReturn(updatedResponse);

        // Act
        ResponseEntity<FurnitureResponseModel> responseEntity = furnitureController.updateFurniture(updatedFurniture, VALID_FURNITURE_ID);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(VALID_FURNITURE_ID, responseEntity.getBody().getFurnitureId());
        verify(furnitureService, times(1)).updateFurniture(VALID_FURNITURE_ID, updatedFurniture);
    }


    @Test
    public void whenFurnitureNotFoundOnGet_ThenThrowNotFoundException() {
        //arrange
        when(furnitureService.getFurnitureByFurnitureId(NOT_FOUND_FURNITURE_ID)).thenThrow(new NotFoundException(
                "Unknown furniture ID: " + NOT_FOUND_FURNITURE_ID));

        //act
        NotFoundException exception = assertThrowsExactly(NotFoundException.class, () -> {
            furnitureController.getFurnitureByFurnitureId(NOT_FOUND_FURNITURE_ID);
        });

        //assert
        assertEquals("Unknown furniture ID: " + NOT_FOUND_FURNITURE_ID, exception.getMessage());
        verify(furnitureService, times(1)).getFurnitureByFurnitureId(NOT_FOUND_FURNITURE_ID);
    }

    @Test
    public void whenFurnitureNotCorrectOnPost_ThenThrowNotValidInputException() {
        //arrange
        when(furnitureService.getFurnitureByFurnitureId(INVALID_FURNITURE_ID)).thenThrow(new InvalidInputException(
                "Not valid furniture ID: " + INVALID_FURNITURE_ID));

        //act
        InvalidInputException exception = assertThrowsExactly(InvalidInputException.class, () -> {
            furnitureController.getFurnitureByFurnitureId(INVALID_FURNITURE_ID);
        });

        //assert
        assertEquals("Not valid furniture ID: " + INVALID_FURNITURE_ID, exception.getMessage());
        verify(furnitureService, times(1)).getFurnitureByFurnitureId(INVALID_FURNITURE_ID);
    }
}


