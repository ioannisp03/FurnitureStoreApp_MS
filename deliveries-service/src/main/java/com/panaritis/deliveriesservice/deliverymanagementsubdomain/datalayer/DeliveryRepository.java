package com.panaritis.deliveriesservice.deliverymanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {

    Delivery findByDeliveryIdentifier_DeliveryId(String deliveryId);

}
