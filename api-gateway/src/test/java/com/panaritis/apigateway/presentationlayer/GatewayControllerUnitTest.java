package com.panaritis.apigateway.presentationlayer;


import com.panaritis.apigateway.domainclientlayer.FurnitureServiceClient;
import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerResponseModel;
import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureResponseModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = CustomerController.class)
public class GatewayControllerUnitTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ObjectMapper mapper;

    private FurnitureServiceClient furnitureServiceClient;
    private CustomerResponseModel customerResponseModel;

    @BeforeEach
    public void setUp() {


        customerResponseModel = CustomerResponseModel.builder()
                .customerId("C123")
                .firstName("John")
                .lastName("Doe")
                .emailAddress("john.doe@example.com")
                .streetAddress("123 Elm Street")
                .city("Anytown")
                .province("Anystate")
                .country("USA")
                .postalCode("12345")
                .build();
    }

    @Test
    public void testNoArgsConstructor() {
        CustomerResponseModel model = new CustomerResponseModel();
        assertNotNull(model);
        assertNull(model.getCustomerId());
    }


    @Test
    void testGetFurniture() {
        FurnitureResponseModel[] mockResponse = {
                new FurnitureResponseModel("1", "Chair", 100.0, "Furniture", "Comfortable chair", "Manufacturer1", "Country1"),
                new FurnitureResponseModel("2", "Table", 200.0, "Furniture", "Sturdy table", "Manufacturer2", "Country2")
        };
        when(restTemplate.getForObject(any(), any())).thenReturn(mockResponse);

        List<FurnitureResponseModel> furnitureList = furnitureServiceClient.getFurniture();

        assertEquals(2, furnitureList.size());
        assertEquals("1", furnitureList.get(0).getFurnitureId());
        assertEquals("Chair", furnitureList.get(0).getFurnitureName());
        assertEquals(100.0, furnitureList.get(0).getFurnitureCost());
        assertEquals("Furniture", furnitureList.get(0).getCategory());
        assertEquals("Comfortable chair", furnitureList.get(0).getDescription());
        assertEquals("Manufacturer1", furnitureList.get(0).getManufacturerName());
        assertEquals("Country1", furnitureList.get(0).getCountry());
        // Add more assertions as needed
    }

    @Test
    void testGetFurnitureByFurnitureId() {
        // Mocking the restTemplate behavior
        FurnitureResponseModel mockResponse = new FurnitureResponseModel("1", "Chair", 100.0, "Furniture", "Comfortable chair", "Manufacturer1", "Country1");
        when(restTemplate.getForObject(any(), any())).thenReturn(mockResponse);

        FurnitureResponseModel furniture = furnitureServiceClient.getFurnitureByFurnitureId("1");

        assertEquals("1", furniture.getFurnitureId());
        assertEquals("Chair", furniture.getFurnitureName());
        assertEquals(100.0, furniture.getFurnitureCost());
        assertEquals("Furniture", furniture.getCategory());
        assertEquals("Comfortable chair", furniture.getDescription());
        assertEquals("Manufacturer1", furniture.getManufacturerName());
        assertEquals("Country1", furniture.getCountry());
        // Add more assertions as needed
    }



}




