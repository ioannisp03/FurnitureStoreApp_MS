//package com.panaritis.apigateway.datalayer;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
////@Transactional(propagation = Propagation.NOT_SUPPORTED)
//public class GatewayRepositoryIntegrationTest {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//
//
//
//    @BeforeEach
//    public void setupDB() {
//        customerRepository.deleteAll();
//    }
//
//    @Test
//    public void whenCustomerDoesNotExist_ReturnNull() {
//        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId("AA9c2c3f-afc9-46fb-8A19-171C8e54F02f");
//
//        //assert
//        assertNull(customer);
//    }
//
//
//    @Test
//    public void whenCustomerExists_ReturnAllCustomers() {
//
//        List<PhoneNumber> phoneNumberList = new ArrayList<>();
//        phoneNumberList.add(new PhoneNumber(PhoneType.HOME, "515-555-1234"));
//        phoneNumberList.add(new PhoneNumber(PhoneType.MOBILE, "438-213-9383"));
//
//        Customer customer1 = new Customer("Susana", "Maxfield", "smaxfield6@themeforest.net",
//                new Address("4509 Mifflin Road", "Acton Vale",
//                        "Québec", "USA", "G0E N6E"), phoneNumberList);
//        Customer customer2 = new Customer("John", "Pan", "example@example.net",
//                new Address("1234 roadhouse Road", "La Prairie",
//                        "Québec", "Canada", "J2F 4C2"), phoneNumberList);
//
//        Customer savedEntity = customerRepository.save(customer1);
//        Customer savedEntity2 = customerRepository.save(customer2);
//
//        List<Customer> customerList = customerRepository.findAll();
//        Long sizeOfDB = customerRepository.count();
//
//        //assert
//        assertNotNull(customerList);
//        assertEquals(customerList.size(), sizeOfDB);
//    }
//
//    @Test
//    public void whenCustomerExists_FindCustomerById() {
//        List<PhoneNumber> phoneNumberList = new ArrayList<>();
//        phoneNumberList.add(new PhoneNumber(PhoneType.HOME, "515-555-1234"));
//        phoneNumberList.add(new PhoneNumber(PhoneType.MOBILE, "438-213-9383"));
//
//        Customer customer1 = new Customer("Susana", "Maxfield", "smaxfield6@themeforest.net",
//                new Address("4509 Mifflin Road", "Acton Vale",
//                        "Québec", "USA", "G0E N6E"), phoneNumberList);
//
//        Customer customer2 = new Customer("John", "Pan", "example@example.net",
//                new Address("1234 roadhouse Road", "La Prairie",
//                        "Québec", "Canada", "J2F 4C2"), phoneNumberList);
//
//
//        Customer savedEntity = customerRepository.save(customer1);
//        Customer savedEntity2 = customerRepository.save(customer2);
//
//        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(
//                customer1.getCustomerIdentifier().getCustomerId()
//        );
//
//        //assert
//        assertNotNull(customer1);
//        assertEquals(customer.getCustomerIdentifier(), customer1.getCustomerIdentifier());
//        assertEquals(customer.getCustomerFirstName(), customer1.getCustomerFirstName());
//        assertEquals(customer.getCustomerLastName(), customer1.getCustomerLastName());
//    }
//
//
//}
