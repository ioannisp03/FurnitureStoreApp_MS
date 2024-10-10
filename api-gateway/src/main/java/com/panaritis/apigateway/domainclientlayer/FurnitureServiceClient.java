package com.panaritis.apigateway.domainclientlayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureRequestModel;
import com.panaritis.apigateway.presentationlayer.furnituredtos.FurnitureResponseModel;
import com.panaritis.apigateway.utils.HttpErrorInfo;
import com.panaritis.apigateway.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
@Slf4j
public class FurnitureServiceClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final String FURNITURE_SERVICE_BASE_URL;

    public FurnitureServiceClient(RestTemplate restTemplate, ObjectMapper mapper,
                                  @Value("${app.furniture-service.host}") String furnitureServiceHost,
                                  @Value("${app.furniture-service.port}") String furnitureServicePort) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.FURNITURE_SERVICE_BASE_URL = "http://" + furnitureServiceHost + ":" + furnitureServicePort + "/api/v1/furniture";
    }


    public List<FurnitureResponseModel> getFurniture(){
        try {
            FurnitureResponseModel[] furnitureResponseModels = this.restTemplate.getForObject(
                    FURNITURE_SERVICE_BASE_URL, FurnitureResponseModel[].class
            );

            assert furnitureResponseModels != null;
            return Arrays.asList(furnitureResponseModels);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public FurnitureResponseModel getFurnitureByFurnitureId(String furnitureId) {
        try{
            String url = FURNITURE_SERVICE_BASE_URL + "/" + furnitureId;

            FurnitureResponseModel furnitureResponseModel = this.restTemplate.getForObject(url, FurnitureResponseModel.class);

            assert furnitureResponseModel != null;
            return furnitureResponseModel;
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }


    public FurnitureResponseModel addFurniture(FurnitureRequestModel furnitureRequestModel){
        try {
            return restTemplate.postForObject(FURNITURE_SERVICE_BASE_URL, furnitureRequestModel, FurnitureResponseModel.class);
        } catch (HttpClientErrorException ex){
            throw handleHttpClientException(ex);
        }
    }

    public void updateFurniture(String furnitureId, FurnitureRequestModel furnitureRequestModel) {
        try {
            String url = FURNITURE_SERVICE_BASE_URL + "/" + furnitureId;
            this.restTemplate.put(url, furnitureRequestModel);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public void deleteFurniture(String furnitureId) {
        try{
            String url = FURNITURE_SERVICE_BASE_URL + "/" + furnitureId;
            this.restTemplate.delete(url);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    private RuntimeException handleHttpClientException (HttpClientErrorException ex){

        if (ex.getStatusCode() == NOT_FOUND) {

            return new NotFoundException(getErrorMessage(ex));
        }
        log.warn("  HTTP error: {}, will rethrow it", ex.getStatusCode());
        log.warn("Error body: {}", ex.getResponseBodyAsString());

        return ex;
    }

    private String getErrorMessage (HttpClientErrorException ex){

        try {

            return mapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class).getMessage();
        } catch (java.io.IOException IOException) {

            return IOException.getMessage();
        }
    }
}
