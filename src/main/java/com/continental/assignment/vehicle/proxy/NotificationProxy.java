package com.continental.assignment.vehicle.proxy;

import com.continental.assignment.vehicle.domain.VehiclePenalty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="notification", url="localhost:8090")
public interface NotificationProxy {
    @PostMapping("/notify/email")
    public Boolean sendEmail(@RequestBody List<VehiclePenalty> violatedVehicleList);
}
