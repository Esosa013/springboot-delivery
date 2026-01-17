package com.example.delivery.controller;

import com.example.delivery.entity.Vehicle;
import com.example.delivery.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // CRUD endpoints
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/plate/{plateNumber}")
    public Vehicle getByPlate(@PathVariable String plateNumber) {
        return vehicleService.getVehicleByPlateNumber(plateNumber);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }

    @GetMapping("/weight/{weight}")
    public List<Vehicle> getByWeight(@PathVariable double weight) {
        return vehicleService.getVehiclesByCarryingWeight(weight);
    }

    @GetMapping("/status/{status}")
    public List<Vehicle> getByStatus(@PathVariable String status) {
        return vehicleService.getVehiclesByStatus(status);
    }
}
