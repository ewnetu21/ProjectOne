package com.example.restApiExercise.Controller;

import com.example.restApiExercise.Model.Accident;
import com.example.restApiExercise.Model.Vehicle;
import com.example.restApiExercise.dto.AccidentDto;
import com.example.restApiExercise.dto.VehicleDto;
import com.example.restApiExercise.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    VehicleRepository vehicleRepository;
    @PostMapping("/vehicles") //POST/ SAVE
    public void createVehicle(@PathVariable int id,@RequestBody VehicleDto vehicleDto){
        Accident accident=new Accident();
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDto.getId());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setMake(vehicleDto.getMake());
        vehicle.setColor(vehicleDto.getColor());
        vehicle.setAccident(accident);

        this.vehicleRepository.save(vehicle);
    }
    @GetMapping("/vehicles")   //GET ALL
    public List<Vehicle> getVehicles(){
        return this.vehicleRepository.findAll();

            }
    @GetMapping("/vehicles/id")   //GET BY ID
    public Vehicle getOneVehicle(@PathVariable int id){
        return this.vehicleRepository.findById(id).orElse(null);
    }
    @DeleteMapping("/vehicles/{id}")  //DELETE
    public void deleteVehicle(@PathVariable int id){
        this.vehicleRepository.deleteById(id);
    }
    @PutMapping("/vehicles/{id}") //EDIT/PUT/UPDATE
    public Vehicle updateVehicle(@PathVariable int id, @RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = this.vehicleRepository.findById(id).orElse(null);
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setMake(vehicleDto.getMake());
        vehicle.setColor(vehicleDto.getColor());
        return this.vehicleRepository.save(vehicle);
    }
    }



