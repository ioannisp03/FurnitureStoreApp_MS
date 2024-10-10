package com.panaritis.customersservice.customermanagementsubdomain.businesslayer;

import com.panaritis.customersservice.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.panaritis.customersservice.customermanagementsubdomain.presentationlayer.CustomerResponseModel;

import java.util.List;
public interface CustomerService {

    List<CustomerResponseModel> getCustomers();
    CustomerResponseModel getCustomerByCustomerId(String customerId);
    CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel);
    CustomerResponseModel updateCustomer(CustomerRequestModel updatedCustomer, String customerId);
    void removeCustomer(String customerId);
}
