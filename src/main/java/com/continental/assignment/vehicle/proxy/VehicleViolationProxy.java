package com.continental.assignment.vehicle.proxy;

import com.continental.assignment.vehicle.domain.VehicleViolation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="vehicle-violation", url="localhost:8081")
public interface VehicleViolationProxy {

    @PostMapping("/violation/violatedVehicles")
    public List<VehicleViolation> getViolatedVehicleList(@RequestBody List<String> vehicles);
}
