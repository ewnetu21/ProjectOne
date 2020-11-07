package com.example.restApiExercise.Controller;

import com.example.restApiExercise.Model.Motorist;
import com.example.restApiExercise.Model.Vehicle;
import com.example.restApiExercise.dto.MotoristDto;
import com.example.restApiExercise.dto.VehicleDto;
import com.example.restApiExercise.exception.MotoristNotFoundException;
import com.example.restApiExercise.exception.VehicleNotFoundException;
import com.example.restApiExercise.repository.MotoristRepository;
import com.example.restApiExercise.services.MotoristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
public class MotoristController {
   @Autowired
  // MotoristRepository motoristRepository;
    MotoristService motoristService;
//@PostMapping("/motorists") //save to database
//public void createMotorist(@PathVariable int id, @RequestBody MotoristDto motoristDto){
//    // lets create user entity object //POST
//    Vehicle vehicle=new Vehicle();
//    Motorist motorist = new Motorist();
//    motorist.setLicence(motoristDto.getLicence());
//    motorist.setFirstname(motoristDto.getFirstname());
//    motorist.setLastname(motoristDto.getLastname());
//    motorist.setVehicle(vehicle);
//    motorist.setAge(motoristDto.getAge());
//    this.motoristRepository.save(motorist);
//}

    @PostMapping("/motorists") //POST/ SAVE
    public ResponseEntity<Object> createMotorist(@RequestBody Motorist motorist){
        Motorist createdMotorist=this.motoristService.createMotorist(motorist);// from 200 ok to created
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(createdMotorist.getLicence()).toUri();
               // .buildAndExpand(createdMotorist.getId()).toUri();
              return ResponseEntity.created(location).build(); // to 200 ok to created
    }

    @GetMapping("/motorists") //GET
   public List<Motorist> getMotorists(){
       return this.motoristService.getMotorist();
   }

    @GetMapping("/motorists/{licence}") //GET SINGLE
    public Motorist getOneMotorist(@PathVariable int licence){
        Motorist motorist= this.motoristService.getOneMotorist(licence);
        return motorist;
    }
    @DeleteMapping("/motorists/{licence}") // DELETE
    public void deleteMotorist(@PathVariable int licence){
        this.motoristService.deleteMotorist(licence);
    }
    @PutMapping("/motorists/{licence}") //EDIT/PUT/UPDATE
    public Motorist updateMotorist(@PathVariable int licence, @RequestBody MotoristDto motoristDto) {
        Motorist motorist = this.motoristService.getOneMotorist(licence);
        motorist.setFirstname(motoristDto.getFirstname());
        motorist.setLastname(motoristDto.getLastname());
        motorist.setAge(motoristDto.getAge());
        return this.motoristService.updateMotorist(licence, motorist);
    }
}
