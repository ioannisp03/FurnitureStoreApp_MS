package com.panaritis.deliveriesservice.presentationlayer;



import com.panaritis.deliveriesservice.deliverymanagementsubdomain.businesslayer.DeliveryService;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer.DeliveryController;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer.DeliveryResponseModel;
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

@SpringBootTest(classes = DeliveryController.class)
public class DeliveriesControllerUnitTest {

    @MockBean
    DeliveryService deliveryService;
    @Autowired
    DeliveryController deliveryController;

    private final String VALID_DELIVERY_ID = "f3a4e8b1-e8d2-47a9-bd80-3d8f5c281f44";

    @Test
    public void whenNoDeliveryExists_ThenReturnEmptyList() {
        //arrange step
        when(deliveryService.getDeliveries()).thenReturn(Collections.emptyList());

        //act
        ResponseEntity<List<DeliveryResponseModel>> deliveryResponseModels = deliveryController.getDeliveries();

        //Assertion step
        assertNotNull(deliveryResponseModels);
        assertEquals(deliveryResponseModels.getStatusCode(), HttpStatus.OK);
        assertArrayEquals(deliveryResponseModels.getBody().toArray(), new ArrayList<DeliveryResponseModel>().toArray());
        verify(deliveryService, times(1)).getDeliveries();
    }

//    @Test
//    public void whenCustomerExists_ThenReturnCustomers() {
//        List<CustomerResponseModel> customerList = buildCustomerResponseModel();
//
////      'when' mocks this controller function behaviour
//        when(customerService.getCustomers()).thenReturn(customerList);
//
//        //act
//        ResponseEntity<List<CustomerResponseModel>> customerResponseEntity = customerController.getCustomers();
//
//        //assert
//        assertNotNull(customerResponseEntity);
//        assertEquals(customerResponseEntity.getStatusCode(), HttpStatus.OK);
//        assertNotNull(customerResponseEntity.getBody());
//        assertEquals(customerResponseEntity.getBody().size(), 2);
//        assertArrayEquals(customerResponseEntity.getBody().toArray(),
//                customerList.toArray());
//
//        verify(customerService, times(1)).getCustomers();
//    }
//
//    public List<CustomerResponseModel> buildCustomerResponseModel() {
//
//        List<PhoneNumber> phoneNumberList = new ArrayList<>();
//        phoneNumberList.add(new PhoneNumber(PhoneType.HOME, "123 234 5642"));
//        phoneNumberList.add(new PhoneNumber(PhoneType.WORK, "321 902 4312"));
//
//
//        CustomerResponseModel customerResponseModel
//                = CustomerResponseModel.builder()
//                .customerId("6b2214d8-8d17-42f3-82bd-1b9264f19c64")
//                .customerFirstName("Ioannis")
//                .customerLastName("Panaritis")
//                .emailAddress("example@yahoo.com")
//                .streetAddress("123 street")
//                .city("Candiac")
//                .province("Quebec")
//                .country("Canada")
//                .postalCode("JXS 1F1")
//                .phoneNumbers(phoneNumberList)
//                .build();
//
//
//        List<PhoneNumber> phoneNumberList2 = new ArrayList<>();
//        phoneNumberList.add(new PhoneNumber(PhoneType.MOBILE, "423 458 9832"));
//        phoneNumberList.add(new PhoneNumber(PhoneType.WORK, "983 123 8921"));
//
//
//        CustomerResponseModel customerResponseModel2
//                = CustomerResponseModel.builder()
//                .customerId(VALID_CUSTOMER_ID)
//                .customerFirstName("John")
//                .customerLastName("Matthews")
//                .emailAddress("example2@yahoo.com")
//                .streetAddress("321 avenue")
//                .city("La prairie")
//                .province("Quebec")
//                .country("Canada")
//                .postalCode("J4X 1X2")
//                .phoneNumbers(phoneNumberList2)
//                .build();
//
//        List<CustomerResponseModel> list = new ArrayList<CustomerResponseModel>();
//        list.add(customerResponseModel);
//        list.add(customerResponseModel2);
//
//        return list;
//    }
//



}
