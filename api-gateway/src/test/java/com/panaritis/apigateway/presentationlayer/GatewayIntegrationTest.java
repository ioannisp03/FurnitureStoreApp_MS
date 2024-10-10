//package com.panaritis.apigateway.presentationlayer;
//
//
//import com.panaritis.customersservice.customermanagementsubdomain.datalayer.CustomerRepository;
//import com.panaritis.customersservice.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//
//
//@SpringBootTest(webEnvironment = RANDOM_PORT, properties = {"spring.datasource.url=jdbc:h2:mem:customer-db"})
//public class GatewayIntegrationTest {
//
//    @Autowired
//    private WebTestClient webTestClient;
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Test
//    public void whenCustomerExists_thenReturnAllCustomers() {
//
//        Long listSize = customerRepository.count();
//
//        webTestClient.get()
//                .uri("api/v1/customers")
//                .accept(APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentType(APPLICATION_JSON)
//                .expectBodyList(CustomerResponseModel.class)
//                .value((list) -> {
//                            assertNotNull(list);
//                            assertEquals(list.size(), listSize);
//                            //
//                            //assert other things
//                        }
//                );
//    }
//
//
//}
//
//
