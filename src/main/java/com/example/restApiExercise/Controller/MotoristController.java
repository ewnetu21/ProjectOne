package com.example.restApiExercise.Controller;

import com.example.restApiExercise.Model.Motorist;
import com.example.restApiExercise.Model.Vehicle;
import com.example.restApiExercise.dto.MotoristDto;
import com.example.restApiExercise.dto.VehicleDto;
import com.example.restApiExercise.repository.MotoristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MotoristController {
   @Autowired
   MotoristRepository motoristRepository;

@PostMapping("/motorists") //save to database
public void createMotorist(@PathVariable int id, @RequestBody MotoristDto motoristDto){
    // lets create user entity object //POST
    Vehicle vehicle=new Vehicle();
    Motorist motorist = new Motorist();
    motorist.setLicence(motoristDto.getLicence());
    motorist.setFirstname(motoristDto.getFirstname());
    motorist.setLastname(motoristDto.getLastname());
    motorist.setVehicle(vehicle);
    motorist.setAge(motoristDto.getAge());
    this.motoristRepository.save(motorist);
}
   @GetMapping("/motorists") //GET
   public List<Motorist> getMotorists(){
       return this.motoristRepository.findAll();
   }
    @GetMapping("/motorists/{licence}") //GET SINGLE
    public Motorist getOneMotorist(@PathVariable int licence){
    return this.motoristRepository.findById(licence).orElse(null);
    }
    @DeleteMapping("/motorists") // DELETE
    public void deleteMotorist(@PathVariable int licence){
        this.motoristRepository.deleteById(licence);
    }
    @PutMapping("/motorists/{licence}") //EDIT/PUT/UPDATE
    public Motorist updateMotorist(@PathVariable int licence, @RequestBody MotoristDto motoristDto) {
        Motorist motorist = this.motoristRepository.findById(licence).orElse(null);
        motorist.setFirstname(motoristDto.getFirstname());
        motorist.setLastname(motoristDto.getLastname());
        motorist.setAge(motoristDto.getAge());
        return this.motoristRepository.save(motorist);
    }
}
