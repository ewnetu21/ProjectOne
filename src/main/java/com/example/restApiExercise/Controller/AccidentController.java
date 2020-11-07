package com.example.restApiExercise.Controller;

import com.example.restApiExercise.Model.Accident;
import com.example.restApiExercise.Model.Motorist;
import com.example.restApiExercise.dto.AccidentDto;
import com.example.restApiExercise.exception.AccidentNotFoundException;
import com.example.restApiExercise.repository.AccidentRepository;
import com.example.restApiExercise.services.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
//@RequestMapping("/accidents")
public class AccidentController {
    @Autowired
    //AccidentRepository accidentRepo;
    AccidentService accidentService;
    @GetMapping("/accidents") //GET
    public List<Accident> getAccidents() {
        return this.accidentService.getAccident();
    }
    @PostMapping("/accidents") //SAVE
    public ResponseEntity<Object> createAccident(@RequestBody AccidentDto accidentDto) {
        Accident accident = new Accident();
        accident.setId(accidentDto.getIdDto());
        accident.setName(accidentDto.getNameDto());
        accident.setAddress(accidentDto.getAddressDto());
        accident.setVehicle(accidentDto.getVehicleDto());
        this.accidentService.createAccident(accident);
//For 201 Created
        Accident createdAccident=this.accidentService.createAccident(accident);
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(createdAccident.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/accidents/{id}") //GET BY ID
    public Accident getOneAccident(@PathVariable int id) {
//        Accident accident= this.accidentRepo.findById(id).orElseThrow(()->
//        new AccidentNotFoundException("No accident with id :"+ id));
//        return accident;

        Accident accident= this.accidentService.getOneAccident(id);
        return accident;
    }
    @DeleteMapping("/accidents/{id}") //DELETE
    public void deleteAccident(@PathVariable int id) {
         this.accidentService.deleteAccident(id);
    }
    @PutMapping("/accidents/{id}") //EDIT/PUT/UPDATE
    public Accident updateAccident(@PathVariable int id, @RequestBody AccidentDto accidentDto) {
        Accident accident = this.accidentService.getOneAccident(id);
        accident.setName(accidentDto.getNameDto());
        accident.setAddress(accidentDto.getAddressDto());
        return this.accidentService.updateAccident(id,accident);
    }
}