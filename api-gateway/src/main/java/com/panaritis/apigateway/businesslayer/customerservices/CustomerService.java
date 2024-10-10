package com.panaritis.apigateway.businesslayer.customerservices;

import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerRequestModel;
import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerResponseModel;

import java.util.List;

public interface CustomerService {

    List<CustomerResponseModel> getCustomers();
    CustomerResponseModel getCustomerById(String customerId);
    CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel);
    void updateCustomer(String customerId, CustomerRequestModel customerRequestModel);
    void removeCustomer(String customerId);
}
