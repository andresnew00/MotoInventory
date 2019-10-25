package com.company.MotoInventoryedge.util.feign;

import com.company.MotoInventoryedge.model.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient("motorcycle-service")
public interface MotoInventoryFeignClient {

    Motorcycle createMotorcycle(Motorcycle moto);

    Motorcycle getMotorcycle(int motorcycleId);

    List<Motorcycle> getAllMotorCycles();

    void updateMotorcycle(int motorcycleId);

    void deleteMotorcycle(int motorcycleId);

}
