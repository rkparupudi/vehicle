package com.continental.assignment.vehicle.service;

import com.continental.assignment.vehicle.model.Vehicle;

import java.util.List;

public interface VehicleService {

    public Vehicle save(Vehicle vehicle);

    public List<Vehicle> getAllVehicles();

    void checkViolations(List<String> vehicles);
}
