package com.example.delivery.service.impl;

import com.example.delivery.entity.Vehicle;
import com.example.delivery.repository.VehicleRepository;
import com.example.delivery.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow();
        vehicle.setPlateNumber(updatedVehicle.getPlateNumber());
        vehicle.setStatus(updatedVehicle.getStatus());
        vehicle.setType(updatedVehicle.getType());
        vehicle.setFuelCapacity(updatedVehicle.getFuelCapacity());
        vehicle.setCarryingWeight(updatedVehicle.getCarryingWeight());
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public Vehicle getVehicleByPlateNumber(String plateNumber) {
        return vehicleRepository.findByPlateNumber(plateNumber);
    }

    @Override
    public List<Vehicle> getVehiclesByCarryingWeight(double weight) {
        return vehicleRepository.findByCarryingWeightGreaterThan(weight);
    }

    @Override
    public List<Vehicle> getVehiclesByStatus(String status) {
        return vehicleRepository.findByStatus(status);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
}
}
