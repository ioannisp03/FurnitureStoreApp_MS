package com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.furniture;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.utils.HttpErrorInfo;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.utils.exceptions.InvalidInputException;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Component
@Slf4j
public class FurnitureServiceClient {
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final String FURNITURE_SERVICES_BASE_URL;

    public FurnitureServiceClient(RestTemplate restTemplate, ObjectMapper mapper,
                                  @Value("${app.furniture-service.host}") String furnitureServiceHost,
                                  @Value("${app.furniture-service.port}") String furnitureServicePort) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.FURNITURE_SERVICES_BASE_URL = "http://" + furnitureServiceHost + ":" + furnitureServicePort + "/api/v1/furniture";
    }

    public FurnitureModel getFurnitureByFurnitureId(String furnitureId) {

        try{
            String url = FURNITURE_SERVICES_BASE_URL + "/" + furnitureId;

            FurnitureModel furnitureModel = restTemplate.getForObject(url, FurnitureModel.class);

            return furnitureModel;

        }catch (HttpClientErrorException ex){

            throw handleHttpClientException(ex);
        }
    }

    private RuntimeException handleHttpClientException(HttpClientErrorException ex){

        if(ex.getStatusCode() == NOT_FOUND){

            return new NotFoundException(getErrorMessage(ex));
        }

        if(ex.getStatusCode() == UNPROCESSABLE_ENTITY){

            return new InvalidInputException(getErrorMessage(ex));
        }

        log.warn("Got an unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
        log.warn("Error body: {}", ex.getResponseBodyAsString());
        return ex;
    }


    private String getErrorMessage(HttpClientErrorException ex){

        try{

            return mapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class).getMessage();

        }catch (IOException IOex){

            return IOex.getMessage();
        }
    }
}



