package com.panaritis.furnitureservice.datalayer;


import com.panaritis.furnitureservice.furnituremanagementsubdomain.datalayer.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class FurnitureRepositoryIntegrationTest {

    @Autowired
    FurnitureRepository furnitureRepository;

    @BeforeEach
    public void setUpDB() {
        furnitureRepository.deleteAll();
    }

    @Test
    public void whenFurnitureDoesNotExist_ReturnNull() {
        Furniture furniture = furnitureRepository.findByFurnitureIdentifier_FurnitureId("AA9c2c3f-afc9-46fb-8A19-171C8e54F02f");
        assertNull(furniture);
    }

    @Test
    public void whenFurnitureExists_ReturnAllFurniture() {
        //Arrange
        Furniture furniture1 = new Furniture(CurrencyType.CAD, new FurniturePriceInformation(200.00),
                new Manufacturer("Manufacturer1", "USA"), "Love Bed",
                "Comfortable sofa for the living room", "Furniture", FurnitureCondition.BRANDNEW);


        //Act
        Furniture savedFurniture = furnitureRepository.save(furniture1);

        Furniture addedFurniture = furnitureRepository.findByFurnitureIdentifier_FurnitureId(
                furniture1.getFurnitureIdentifier().getFurnitureId()
        );

        //Assertion Step
        assertNotNull(addedFurniture);
        assertEquals(furniture1.getFurnitureIdentifier(), addedFurniture.getFurnitureIdentifier());
        //check if all properties are the same
        assertThat(savedFurniture, samePropertyValuesAs(furniture1));
    }

}
