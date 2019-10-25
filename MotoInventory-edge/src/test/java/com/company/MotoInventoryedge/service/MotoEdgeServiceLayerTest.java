package com.company.MotoInventoryedge.service;

import com.company.MotoInventoryedge.model.Motorcycle;
import com.company.MotoInventoryedge.model.MotorcyclePurchaseViewModel;
import com.company.MotoInventoryedge.util.feign.MotoInventoryFeignClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class MotoEdgeServiceLayerTest {

    @InjectMocks
    MotoEdgeServiceLayer serviceLayer;

    @Mock
    MotoInventoryFeignClient feignClient;

    Motorcycle motorcycle, motorcycle2;

    MotorcyclePurchaseViewModel mpvm;

    @BeforeEach
    void setUp() {
        motorcycle = new Motorcycle();
        motorcycle.setMotorcycleId(1);
        motorcycle.setPrice(new BigDecimal("1000"));
        motorcycle.setVin("11111aAAAAAA");
        motorcycle.setMake("Honda");
        motorcycle.setModel("Moto");
        motorcycle.setYear("1999");
        motorcycle.setColor("Black");

        motorcycle2 = new Motorcycle();
        motorcycle2.setMotorcycleId(2);
        motorcycle2.setPrice(new BigDecimal("1000"));
        motorcycle2.setVin("11111aAAAAAA");
        motorcycle2.setMake("Toyota");
        motorcycle2.setModel("Moto");
        motorcycle2.setYear("1999");
        motorcycle2.setColor("Green");

        mpvm = new MotorcyclePurchaseViewModel();
        mpvm.setMotorcycleId(1);
        mpvm.setPrice(new BigDecimal("1000"));
        mpvm.setVin("11111aAAAAAA");
        mpvm.setMake("Honda");
        mpvm.setModel("Moto");
        mpvm.setYear("1999");
        mpvm.setColor("Black");
        mpvm.setSalesTax(new BigDecimal("1000"));
        mpvm.setDocumentationFees(new BigDecimal("1000"));
        mpvm.setTransportationCosts(new BigDecimal("1000"));
        mpvm.setTotal(new BigDecimal("100000"));

        List<Motorcycle> motos = new ArrayList<>();
        motos.add(motorcycle);
        motos.add(motorcycle2);

        lenient().doReturn(motorcycle).when(feignClient).createMotorcycle(motorcycle);
        lenient().doReturn(motos).when(feignClient).getAllMotorCycles();
    }

    @Test
    void createPurchase() {
        feignClient.createMotorcycle(motorcycle);
        MotorcyclePurchaseViewModel created = serviceLayer.createPurchase(motorcycle);

        assertEquals(created,mpvm);
    }

    @Test
    void allMotorcycles() {
        assertEquals(2,serviceLayer.giveAllMotorcycles());
    }


}