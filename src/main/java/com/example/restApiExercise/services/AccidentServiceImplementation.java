package com.example.restApiExercise.services;

import com.example.restApiExercise.Model.Accident;
import com.example.restApiExercise.Model.Vehicle;
import com.example.restApiExercise.exception.AccidentNotFoundException;
import com.example.restApiExercise.repository.AccidentRepository;
import com.example.restApiExercise.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentServiceImplementation implements AccidentService{
    @Autowired
    AccidentRepository accidentRepo;
    @Override
    public List<Accident> getAccident() {
        return this.accidentRepo.findAll();
    }

    @Override
    public Accident getOneAccident(int id) {
        return (this.accidentRepo.findById(id).orElseThrow(()->
                new AccidentNotFoundException("No accident with id:"+ id)));



     }
    @Override
    public void deleteAccident(int id) {
        this.accidentRepo.deleteById(id);
    }

    @Override
    public Accident createAccident(Accident accident) {
        return this.accidentRepo.save(accident);
    }

    @Override
    public Accident updateAccident(int id, Accident accident) {
        return accidentRepo.save(accident);

    }


}
