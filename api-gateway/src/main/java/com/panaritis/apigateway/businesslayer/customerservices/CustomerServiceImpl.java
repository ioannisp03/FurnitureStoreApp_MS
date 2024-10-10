package com.panaritis.apigateway.businesslayer.customerservices;

import com.panaritis.apigateway.datamapperlayer.customermappers.CustomerResponseMapper;
import com.panaritis.apigateway.domainclientlayer.CustomersServiceClient;
import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerRequestModel;
import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomersServiceClient customersServiceClient;
    private final CustomerResponseMapper customerResponseMapper;


    public CustomerServiceImpl(CustomersServiceClient customersServiceClient, CustomerResponseMapper customerResponseMapper) {
        this.customersServiceClient = customersServiceClient;
        this.customerResponseMapper = customerResponseMapper;
    }

    @Override
    public List<CustomerResponseModel> getCustomers() {
        return customersServiceClient.getCustomers();
    }

    @Override
    public CustomerResponseModel getCustomerById(String customerId) {
        return this.customersServiceClient.getCustomerByCustomerId(customerId);
    }

    @Override
    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel) {
        return this.customersServiceClient.addCustomer(customerRequestModel);
    }

    @Override
    public void updateCustomer(String customerId, CustomerRequestModel customerRequestModel) {
        this.customersServiceClient.updateCustomer(customerId, customerRequestModel);

    }
    @Override
    public void removeCustomer(String customerId) {
        customersServiceClient.deleteCustomer(customerId);
    }
}
