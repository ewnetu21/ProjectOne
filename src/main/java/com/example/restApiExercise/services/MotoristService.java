package com.example.restApiExercise.services;

import com.example.restApiExercise.Model.Accident;
import com.example.restApiExercise.Model.Motorist;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MotoristService {
    List<Motorist> getMotorist();
    Motorist getOneMotorist(int id);
    void deleteMotorist(int id);
    Motorist createMotorist(Motorist motorist);
    Motorist updateMotorist(int id, Motorist motorist);
}
