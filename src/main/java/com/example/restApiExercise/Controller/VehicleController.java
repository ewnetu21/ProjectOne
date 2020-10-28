package com.example.restApiExercise.Controller;

import com.example.restApiExercise.Model.Accident;
import com.example.restApiExercise.Model.Vehicle;
import com.example.restApiExercise.dto.AccidentDto;
import com.example.restApiExercise.dto.VehicleDto;
//import com.example.restApiExercise.exception.VehicleNotFoundException;
import com.example.restApiExercise.exception.VehicleNotFoundException;
import com.example.restApiExercise.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    VehicleRepository vehicleRepository;
    @PostMapping("/vehicles") //POST/ SAVE
    public ResponseEntity<Object> createVehicle(@Valid @RequestBody Vehicle vehicle){
       // public ResponseEntity<Object> createVehicle(@RequestBody VehicleDto vehicleDto){ //@PathVariable int id, for validation instead of DTO we will use class
     //no DTo is needed here to post the vehicle into the database
     //  Accident accident=new Accident();
//        Vehicle vehicle = new Vehicle();
//        vehicle.setId(vehicleDto.getId());
//        vehicle.setModel(vehicleDto.getModel());
//        vehicle.setMake(vehicleDto.getMake());
//        vehicle.setColor(vehicleDto.getColor());
       // vehicle.setAccident(accident);
        Vehicle createdVehicle=this.vehicleRepository.save(vehicle);// from 200 ok to created
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(createdVehicle.getId()).toUri();
        return ResponseEntity.created(location).build(); // to 200 ok to created
    }

    @GetMapping("/vehicles")   //GET ALL
    public List<Vehicle> getVehicles(){
        return this.vehicleRepository.findAll();
            }
//    @GetMapping("/vehicles/{id}")   //GET BY ID with 200 ok
//    public Vehicle getOneVehicle(@PathVariable int id){
//        return this.vehicleRepository.findById(id).orElse(null);
//    }

    @GetMapping("/vehicles/{id}")   //GET BY ID
    public Vehicle getOneVehicle(@PathVariable int id){
       Vehicle vehicle= this.vehicleRepository.findById(id).orElseThrow(()->
        new VehicleNotFoundException("No vehicle with  id:" + id));
        return vehicle;
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



