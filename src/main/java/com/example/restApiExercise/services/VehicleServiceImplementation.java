package com.example.restApiExercise.services;

import com.example.restApiExercise.Model.Vehicle;
import com.example.restApiExercise.exception.VehicleNotFoundException;
import com.example.restApiExercise.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImplementation implements VehicleService{
@Autowired
    VehicleRepository vehicleRepository;
    @Override
    public List<Vehicle> getVehicle() {
        return this.vehicleRepository.findAll();
    }

    @Override
    public Vehicle getOneVehicle(int id) {
        return this.vehicleRepository.findById(id).orElseThrow(()->
                new VehicleNotFoundException("No Vehicle with id:"+ id));
    }

    @Override
    public void deleteVehicle(int id) {
       this.vehicleRepository.deleteById(id);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(int id, Vehicle vehicle) {
       return vehicleRepository.save(vehicle);

    }
}
