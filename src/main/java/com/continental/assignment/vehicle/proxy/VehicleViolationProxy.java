package com.continental.assignment.vehicle.proxy;

import com.continental.assignment.vehicle.domain.VehicleViolation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="vehicle-violation", url="localhost:8081")
public interface VehicleViolationProxy {

    @RequestMapping(value="/violation/violatedVehicles")
    public List<VehicleViolation> getViolatedVehicleList(List<String> vehicles);
}
