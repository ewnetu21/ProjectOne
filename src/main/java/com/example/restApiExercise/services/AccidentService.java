package com.example.restApiExercise.services;

import com.example.restApiExercise.Model.Accident;
import com.example.restApiExercise.Model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccidentService {
    List<Accident> getAccident();
    Accident getOneAccident(int id);
    void deleteAccident(int id);
    Accident createAccident(Accident accident);
    Accident updateAccident(int id, Accident accident);
}
