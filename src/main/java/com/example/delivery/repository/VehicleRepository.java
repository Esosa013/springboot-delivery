package com.example.delivery.repository;

import com.example.delivery.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByCarryingWeightGreaterThan(double weight);
    List<Vehicle> findByStatus(String status);
    Vehicle findByPlateNumber(String plateNumber);
}
