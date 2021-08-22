package com.continental.assignment.vehicle.proxy;

import com.continental.assignment.vehicle.domain.VehiclePenalty;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="notification", url="localhost:8082")
public interface NotificationProxy {
    @PostMapping("/notify/email")
    public List<VehiclePenalty> sendEmail(List<VehiclePenalty> violatedVehicleList);
}
