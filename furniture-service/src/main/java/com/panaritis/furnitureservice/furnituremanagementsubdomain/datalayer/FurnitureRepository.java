package com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer;

import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture,Integer> {

    Furniture findByFurnitureIdentifier_FurnitureId(String furnitureId);
    

}
