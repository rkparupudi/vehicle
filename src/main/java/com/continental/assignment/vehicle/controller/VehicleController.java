package com.continental.assignment.vehicle.controller;

import com.continental.assignment.vehicle.model.Vehicle;
import com.continental.assignment.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService service;


    @PostMapping("/add")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        service.save(vehicle);
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
    }

    @GetMapping("/checkViolatedList")
    public ResponseEntity<String> checkVehicleViolation(@RequestBody List<String> vehicles) {
        service.checkViolations(vehicles);
        return new ResponseEntity<String>("Email sent", HttpStatus.OK);
    }
}
