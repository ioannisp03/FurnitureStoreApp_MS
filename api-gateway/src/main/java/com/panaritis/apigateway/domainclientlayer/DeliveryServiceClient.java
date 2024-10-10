package com.panaritis.apigateway.domainclientlayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerResponseModel;
import com.panaritis.apigateway.presentationlayer.deliverydto.DeliveryRequestModel;
import com.panaritis.apigateway.presentationlayer.deliverydto.DeliveryResponseModel;
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
public class DeliveryServiceClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final String DELIVERIES_SERVICE_BASE_URL;

    public DeliveryServiceClient(RestTemplate restTemplate, ObjectMapper mapper,
                                 @Value("${app.deliveries-service.host}") String deliveryServiceHost,
                                 @Value("${app.deliveries-service.port}") String deliveriesServicePort) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.DELIVERIES_SERVICE_BASE_URL = "http://" + deliveryServiceHost + ":" + deliveriesServicePort + "/api/v1/deliveries";
    }


    public List<DeliveryResponseModel> getDeliveries(){
        try {
            DeliveryResponseModel[] deliveryResponseModels = this.restTemplate.getForObject(
                    DELIVERIES_SERVICE_BASE_URL, DeliveryResponseModel[].class
            );

            assert deliveryResponseModels != null;
            return Arrays.asList(deliveryResponseModels);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }


    public DeliveryResponseModel getDeliveryByDeliveryId(String deliveryId) {

        try {

            String url = DELIVERIES_SERVICE_BASE_URL + "/" + deliveryId;

            DeliveryResponseModel deliveryModel = restTemplate.getForObject(url, DeliveryResponseModel.class);

            return deliveryModel;


        } catch (HttpClientErrorException ex) {

            throw handleHttpClientException(ex);
        }

    }

    public DeliveryResponseModel addDelivery(DeliveryRequestModel deliveryRequestModel){
        try {
            return restTemplate.postForObject(
                    DELIVERIES_SERVICE_BASE_URL, deliveryRequestModel, DeliveryResponseModel.class);
        } catch (HttpClientErrorException ex){
            throw handleHttpClientException(ex);
        }
    }
    public DeliveryResponseModel updateDeliveries(String deliveryId, DeliveryRequestModel deliveryRequestModel) {
        try {
            String url = DELIVERIES_SERVICE_BASE_URL + "/" + deliveryId;
            this.restTemplate.put(url, deliveryRequestModel);
            return getDeliveryByDeliveryId(deliveryId);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public void deleteDelivery(String deliveryId) {
        try{
            String url = DELIVERIES_SERVICE_BASE_URL + "/" + deliveryId;
            this.restTemplate.delete(url);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }
    private RuntimeException handleHttpClientException (HttpClientErrorException ex){

        if (ex.getStatusCode() == NOT_FOUND) {

            return new NotFoundException(getErrorMessage(ex));
        }
        log.warn("Got an unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
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
