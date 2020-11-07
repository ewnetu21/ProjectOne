package com.example.restApiExercise.services;

import com.example.restApiExercise.Model.Accident;
import com.example.restApiExercise.Model.Motorist;
import com.example.restApiExercise.exception.MotoristNotFoundException;
import com.example.restApiExercise.repository.AccidentRepository;
import com.example.restApiExercise.repository.MotoristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristServiceImplementation implements MotoristService {
    @Autowired
    MotoristRepository motoristRepository;
    @Override
    public List<Motorist> getMotorist() {
        return this.motoristRepository.findAll();
    }

    @Override
    public Motorist getOneMotorist(int id) {
        return this.motoristRepository.findById(id).orElseThrow(()->
                new MotoristNotFoundException("No motorist with id:"+ id));
    }

    @Override
    public void deleteMotorist(int id) {
        this.motoristRepository.deleteById(id);
    }

    @Override
    public Motorist createMotorist(Motorist motorist) {
        return this.motoristRepository.save(motorist);
    }

    @Override
    public Motorist updateMotorist(int id, Motorist motorist) {
        return motoristRepository.save(motorist);

    }

}
