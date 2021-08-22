package com.continental.assignment.vehicle.repository;

import com.continental.assignment.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

   public Vehicle findVehicleById(String vehicleId);
}
