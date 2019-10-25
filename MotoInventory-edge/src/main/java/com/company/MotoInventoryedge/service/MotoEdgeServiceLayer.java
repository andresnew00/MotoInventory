package com.company.MotoInventoryedge.service;

import com.company.MotoInventoryedge.util.feign.MotoInventoryFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MotoEdgeServiceLayer {

    @Autowired
    MotoInventoryFeignClient client;

    @Autowired
    public MotoEdgeServiceLayer(MotoInventoryFeignClient client) {
        this.client = client;
    }

    //The edge microservice must enforce the following business rules in the service layer:
    //
    //Sales tax is 6.75% and is added to the purchase price of the motorcycle.
    //Document fees are $234. These are added to the purchase price of the motorcyle
    // but are not subject to sales tax.
    //Transportation costs are $395 for motorcycles costing less than $9999 and $499 for motorcycles
    // costing more than $9999.
}
