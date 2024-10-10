package com.panaritis.customersservice.presentationlayer;


import com.panaritis.customersservice.customermanagementsubdomain.businesslayer.CustomerService;
import com.panaritis.customersservice.customermanagementsubdomain.datalayer.PhoneNumber;
import com.panaritis.customersservice.customermanagementsubdomain.datalayer.PhoneType;
import com.panaritis.customersservice.customermanagementsubdomain.presentationlayer.CustomerController;
import com.panaritis.customersservice.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import org.apache.coyote.Response;

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

@SpringBootTest(classes = CustomerController.class)
public class CustomerControllerUnitTest {

    @MockBean
    CustomerService customerService;
    @Autowired
    CustomerController customerController;

    private final String VALID_CUSTOMER_ID = "2b6d4f32-1d63-4c9c-b0d1-29de9467fc2a";

    @Test
    public void whenNoCustomerExists_ThenReturnEmptyList() {
        //arrange step
        when(customerService.getCustomers()).thenReturn(Collections.emptyList());

        //act
        ResponseEntity<List<CustomerResponseModel>> customerResponseEntity = customerController.getCustomers();

        //Assertion step
        assertNotNull(customerResponseEntity);
        assertEquals(customerResponseEntity.getStatusCode(), HttpStatus.OK);
        assertArrayEquals(customerResponseEntity.getBody().toArray(), new ArrayList<CustomerResponseModel>().toArray());
        verify(customerService, times(1)).getCustomers();
    }

    @Test
    public void whenCustomerExists_ThenReturnCustomers() {
        List<CustomerResponseModel> customerList = buildCustomerResponseModel();

//      'when' mocks this controller function behaviour
        when(customerService.getCustomers()).thenReturn(customerList);

        //act
        ResponseEntity<List<CustomerResponseModel>> customerResponseEntity = customerController.getCustomers();

        //assert
        assertNotNull(customerResponseEntity);
        assertEquals(customerResponseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(customerResponseEntity.getBody());
        assertEquals(customerResponseEntity.getBody().size(), 2);
        assertArrayEquals(customerResponseEntity.getBody().toArray(),
                customerList.toArray());

        verify(customerService, times(1)).getCustomers();
    }

    public List<CustomerResponseModel> buildCustomerResponseModel() {

        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(PhoneType.HOME, "123 234 5642"));
        phoneNumberList.add(new PhoneNumber(PhoneType.WORK, "321 902 4312"));


        CustomerResponseModel customerResponseModel
                = CustomerResponseModel.builder()
                .customerId("6b2214d8-8d17-42f3-82bd-1b9264f19c64")
                .customerFirstName("Ioannis")
                .customerLastName("Panaritis")
                .emailAddress("example@yahoo.com")
                .streetAddress("123 street")
                .city("Candiac")
                .province("Quebec")
                .country("Canada")
                .postalCode("JXS 1F1")
                .phoneNumbers(phoneNumberList)
                .build();


        List<PhoneNumber> phoneNumberList2 = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(PhoneType.MOBILE, "423 458 9832"));
        phoneNumberList.add(new PhoneNumber(PhoneType.WORK, "983 123 8921"));


        CustomerResponseModel customerResponseModel2
                = CustomerResponseModel.builder()
                .customerId(VALID_CUSTOMER_ID)
                .customerFirstName("John")
                .customerLastName("Matthews")
                .emailAddress("example2@yahoo.com")
                .streetAddress("321 avenue")
                .city("La prairie")
                .province("Quebec")
                .country("Canada")
                .postalCode("J4X 1X2")
                .phoneNumbers(phoneNumberList2)
                .build();

        List<CustomerResponseModel> list = new ArrayList<CustomerResponseModel>();
        list.add(customerResponseModel);
        list.add(customerResponseModel2);

        return list;
    }




}
