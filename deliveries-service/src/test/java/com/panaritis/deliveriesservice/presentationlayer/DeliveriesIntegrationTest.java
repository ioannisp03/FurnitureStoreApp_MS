package com.panaritis.deliveriesservice.presentationlayer;


import com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer.DeliveryRepository;
import com.panaritis.deliveriesservice.deliverymanagementsubdomain.presentationlayer.DeliveryResponseModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;


@SpringBootTest(webEnvironment = RANDOM_PORT, properties = {"spring.datasource.url=jdbc:h2:mem:delivery-db"})
public class DeliveriesIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    public void whenDeliveryExists_thenReturnAllDeliveries() {

        Long listSize = deliveryRepository.count();

        webTestClient.get()
                .uri("api/v1/deliveries")
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBodyList(DeliveryResponseModel.class)
                .value((list) -> {
                            assertNotNull(list);
                            assertEquals(list.size(), listSize);
                            //
                            //assert other things
                        }
                );
    }


}


