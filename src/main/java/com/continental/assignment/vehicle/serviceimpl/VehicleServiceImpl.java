package com.continental.assignment.vehicle.serviceimpl;

import com.continental.assignment.vehicle.domain.VehiclePenalty;
import com.continental.assignment.vehicle.domain.VehicleViolation;
import com.continental.assignment.vehicle.model.Vehicle;
import com.continental.assignment.vehicle.proxy.NotificationProxy;
import com.continental.assignment.vehicle.proxy.VehicleViolationProxy;
import com.continental.assignment.vehicle.repository.VehicleRepository;
import com.continental.assignment.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Autowired
    VehicleViolationProxy violationProxy;

    @Autowired
    NotificationProxy notificationProxy;

    @Override
    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return null;
    }

    @Override
    public void checkViolations(List<String> vehicles) {
       List<VehicleViolation> violations = violationProxy.getViolatedVehicleList(vehicles);
       List<VehiclePenalty> penaltyVehicles = violations.stream().map(violation -> {
           Vehicle vehicle = repository.findVehicleById(violation.getVehicleId());
           VehiclePenalty penalty = new VehiclePenalty();
           penalty.setVehicleNumber(vehicle.getId());
           penalty.setOwner(vehicle.getOwner());
           penalty.setViolationDescription(violation.getDescription());
           penalty.setPenalty(violation.getPenalty());
           return penalty;

       }).collect(Collectors.toList());
        System.out.println("Penalty Vehicles" +penaltyVehicles);
        penaltyVehicles.forEach(penalty -> System.out.println(penalty.getVehicleNumber()));
         notificationProxy.sendEmail(penaltyVehicles);
    }
}
