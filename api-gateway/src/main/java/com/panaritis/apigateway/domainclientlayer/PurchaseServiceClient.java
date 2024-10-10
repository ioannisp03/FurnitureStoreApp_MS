package com.panaritis.apigateway.domainclientlayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panaritis.apigateway.presentationlayer.purchasedto.PurchaseRequestModel;
import com.panaritis.apigateway.presentationlayer.purchasedto.PurchaseResponseModel;
import com.panaritis.apigateway.utils.exceptions.InvalidInputException;
import com.panaritis.apigateway.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Component
@Slf4j
public class PurchaseServiceClient {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String PURCHASES_SERVICE_BASE_URL;

    public PurchaseServiceClient(RestTemplate restTemplate, ObjectMapper objectMapper,
                                 @Value("${app.purchases-service.host}") String purchaseServiceHost,
                                 @Value("${app.purchases-service.port}") String purchaseServicePort) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        PURCHASES_SERVICE_BASE_URL = "http://" + purchaseServiceHost + ":" + purchaseServicePort + "/api/v1/customers";
    }

    public List<PurchaseResponseModel> getPurchases(String customerId) {
        try {
            String url = PURCHASES_SERVICE_BASE_URL + "/" + customerId + "/purchases";

            PurchaseResponseModel[] purchaseResponseModels = restTemplate.getForObject(
                    url, PurchaseResponseModel[].class
            );

            assert purchaseResponseModels != null;
            return Arrays.asList(purchaseResponseModels);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }


    public PurchaseResponseModel getPurchaseByPurchaseId(String customerId, String purchaseId) {
        try {
            String url = PURCHASES_SERVICE_BASE_URL + "/" + customerId + "/purchases" + "/" + purchaseId;

            PurchaseResponseModel purchaseResponseModel = restTemplate.getForObject(url, PurchaseResponseModel.class);

            assert purchaseResponseModel != null;
            return purchaseResponseModel;
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public PurchaseResponseModel addPurchase(String customerId, PurchaseRequestModel purchaseRequestModel) {
        try {
            String url = PURCHASES_SERVICE_BASE_URL + "/" + customerId + "/purchases";
            return restTemplate.postForObject(url, purchaseRequestModel, PurchaseResponseModel.class);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public PurchaseResponseModel updatePurchase(PurchaseRequestModel purchaseRequestModel, String purchaseId, String customerId) {
        try {
            String url = PURCHASES_SERVICE_BASE_URL + "/" + customerId + "/" + purchaseId;
            restTemplate.put(url, purchaseRequestModel);
            return getPurchaseByPurchaseId(purchaseId,customerId);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public void deletePurchase(String purchaseId, String customerId) {
        try {
            String url = PURCHASES_SERVICE_BASE_URL + customerId + "/purchases" + purchaseId;
            restTemplate.delete(url);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    private RuntimeException handleHttpClientException(org.springframework.web.client.HttpClientErrorException ex) {

        if (ex.getStatusCode() == NOT_FOUND) {
            return new NotFoundException();
        } else if (ex.getStatusCode() == UNPROCESSABLE_ENTITY) {
            return new InvalidInputException();
        }
        return ex;
    }
}

