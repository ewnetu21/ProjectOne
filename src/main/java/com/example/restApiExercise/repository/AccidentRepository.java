package com.example.restApiExercise.repository;

import com.example.restApiExercise.Model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident,Integer> {

}
