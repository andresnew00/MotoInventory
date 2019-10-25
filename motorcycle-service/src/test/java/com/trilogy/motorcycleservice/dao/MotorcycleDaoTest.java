package com.trilogy.motorcycleservice.dao;

import com.trilogy.motorcycleservice.model.Motorcycle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MotorcycleDaoTest {
    @Autowired
    MotorcycleDao motoRepo;

    Motorcycle moto1;
    Motorcycle moto2;

    @Before
    public void setUp() throws Exception {
        motoRepo.deleteAll();
        moto1 = new Motorcycle(
                BigDecimal.valueOf(1000.99), "12345", "Honda", "Vroom", "1999", "Black"
        );
        moto2 = new Motorcycle(
              BigDecimal.valueOf(1000.99), "12345", "Honda", "Vroom", "1999", "Black"
        );

    }

    @Test
    public void testCreateMotorcycle(){
        moto1 = motoRepo.save(moto1);
        Optional<Motorcycle> fromRepo = motoRepo.findById(Long.valueOf(moto1.getMotorcycleId()));
        assertTrue(fromRepo.isPresent());
        assertEquals(moto1, fromRepo.get());
    }
    @Test
    public void testReadMotorcycle(){

    }
    @Test
    public void testUpdateMotorcycle(){

    }
    @Test
    public void testDeleteMotorcycle(){

    }

}