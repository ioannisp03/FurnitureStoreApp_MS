package com.panaritis.apigateway.domainclientlayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerRequestModel;
import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerResponseModel;
import com.panaritis.apigateway.utils.HttpErrorInfo;
import com.panaritis.apigateway.utils.exceptions.InvalidInputException;
import com.panaritis.apigateway.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;


@Component
@Slf4j
public class CustomersServiceClient {
private final RestTemplate restTemplate;
private final ObjectMapper objectMapper;
    private final String CUSTOMERS_SERVICE_BASE_URL;


    public CustomersServiceClient(RestTemplate restTemplate, ObjectMapper objectMapper,
                                  @Value("${app.customers-service.host}") String customerServiceHost,
                                  @Value("${app.customers-service.port}") String customerServicePort) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.CUSTOMERS_SERVICE_BASE_URL = "http://" + customerServiceHost + ":" + customerServicePort + "/api/v1/customers";
    }

    public List<CustomerResponseModel> getCustomers(){
        try {
            CustomerResponseModel[] customerResponseModels = this.restTemplate.getForObject(
                    CUSTOMERS_SERVICE_BASE_URL, CustomerResponseModel[].class
            );

            assert customerResponseModels != null;
            return Arrays.asList(customerResponseModels);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public CustomerResponseModel getCustomerByCustomerId(String customerId) {
        try{
            String url = CUSTOMERS_SERVICE_BASE_URL + "/" + customerId;

            CustomerResponseModel customerResponseModel = this.restTemplate.getForObject(url, CustomerResponseModel.class);

            assert customerResponseModel != null;
            return customerResponseModel;
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }


    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel){
        try {
            return restTemplate.postForObject(CUSTOMERS_SERVICE_BASE_URL, customerRequestModel, CustomerResponseModel.class);
        } catch (HttpClientErrorException ex){
            throw handleHttpClientException(ex);
        }
    }

    public void updateCustomer(String customerId, CustomerRequestModel customerRequestModel) {
        try {
            String url = CUSTOMERS_SERVICE_BASE_URL + "/" + customerId;
            this.restTemplate.put(url, customerRequestModel);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public void deleteCustomer(String customerId) {
        try{
            String url = CUSTOMERS_SERVICE_BASE_URL + "/" + customerId;
            this.restTemplate.delete(url);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    private String getErrorMessage(HttpClientErrorException ex) {
        try {
            return objectMapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class). getMessage();
        } catch (IOException ioex) {
            return ioex.getMessage();
        }
    }


    private RuntimeException handleHttpClientException(org.springframework.web.client.HttpClientErrorException ex) {

        if(ex.getStatusCode() == NOT_FOUND) {
            return new NotFoundException();
        } else if(ex.getStatusCode() == UNPROCESSABLE_ENTITY){
            return new InvalidInputException();
        }

        return ex;
    }
}
