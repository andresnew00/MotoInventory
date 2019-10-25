package com.company.MotoInventoryedge.service;

import com.company.MotoInventoryedge.model.Motorcycle;
import com.company.MotoInventoryedge.model.MotorcyclePurchaseViewModel;
import com.company.MotoInventoryedge.util.feign.MotoInventoryFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class MotoEdgeServiceLayer {

    @Autowired
    MotoInventoryFeignClient client;

    @Autowired
    public MotoEdgeServiceLayer(MotoInventoryFeignClient client) {
        this.client = client;
    }

    public List<Motorcycle> giveAllMotorcycles(){
        return client.getAllMotorCycles();
    }

    //The edge microservice must enforce the following business rules in the service layer:
    //

    public MotorcyclePurchaseViewModel createPurchase(Motorcycle motorcycle){
        BigDecimal purchasePrice;
        BigDecimal moto9999 = new BigDecimal("9999");

        MotorcyclePurchaseViewModel mpvm = new MotorcyclePurchaseViewModel();
        mpvm.setMotorcycleId(motorcycle.getMotorcycleId());
        mpvm.setPrice(motorcycle.getPrice());
        mpvm.setVin(motorcycle.getVin());
        mpvm.setMake(motorcycle.getMake());
        mpvm.setModel(motorcycle.getModel());
        mpvm.setYear(motorcycle.getYear());
        mpvm.setColor(motorcycle.getColor());
        //Sales tax is 6.75% and is added to the purchase price of the motorcycle.
        mpvm.setSalesTax(new BigDecimal("0.0675"));
        //Document fees are $234. These are added to the purchase price of the motorcyle
        // but are not subject to sales tax.
        mpvm.setDocumentationFees(new BigDecimal("234"));
        //Transportation costs are $395 for motorcycles costing less than $9999 and $499 for motorcycles
        if(motorcycle.getPrice().compareTo(moto9999) < 0){
            mpvm.setTransportationCosts(new BigDecimal("395"));
        } else {
            mpvm.setTransportationCosts(new BigDecimal("499"));
        }
        
        mpvm.setTotal(motorcycle.getPrice());

        return mpvm;
    }



    // costing more than $9999.


}
