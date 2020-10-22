package com.example.restApiExercise.repository;

import com.example.restApiExercise.Model.Motorist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristRepository extends JpaRepository<Motorist,Integer> {
}
