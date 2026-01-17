package com.example.delivery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plateNumber;
    private String status;
    private String type;
    private double fuelCapacity;
    private double carryingWeight;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Item> items;
}
