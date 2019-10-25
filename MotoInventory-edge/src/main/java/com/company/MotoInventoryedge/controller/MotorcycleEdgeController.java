package com.company.MotoInventoryedge.controller;

import com.company.MotoInventoryedge.model.Motorcycle;
import com.company.MotoInventoryedge.model.MotorcyclePurchaseViewModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MotorcycleEdgeController {

    //endpoint that allows customers to see the motorcycles currently in inventory.
    public Motorcycle seeAllMotorcycles(){
        return null;
    }
    //endpoint that allows customers to purchase a motorcycle. This endpoint takes in
    // all the information about the motorcycle being purchased and returns the motorcycle
    // information along with information about sales tax, documentation fees, transportation costs,
    // and total cost of the motorcycle. (NOT STORED)
    public MotorcyclePurchaseViewModel buyMoto(Motorcycle motorcycle){
        return null;
    }


}
