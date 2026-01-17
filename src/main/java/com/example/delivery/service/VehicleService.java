package com.example.delivery.service;

import com.example.delivery.entity.Vehicle;
import java.util.List;

public interface VehicleService {
    Vehicle getVehicleById(Long id);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
    Vehicle getVehicleByPlateNumber(String plateNumber);
    List<Vehicle> getVehiclesByCarryingWeight(double weight);
    List<Vehicle> getVehiclesByStatus(String status);
    List<Vehicle> getAllVehicles();
}
