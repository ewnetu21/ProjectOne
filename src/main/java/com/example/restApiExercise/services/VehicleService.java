package com.example.restApiExercise.services;

import com.example.restApiExercise.Model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    List<Vehicle> getVehicle();
    Vehicle getOneVehicle(int id);
    void deleteVehicle(int id);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(int id, Vehicle vehicle);
}
