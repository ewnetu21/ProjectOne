package com.example.restApiExercise.dto;

import com.example.restApiExercise.Model.Motorist;

import java.util.Set;

public class VehicleDto {
    private int id;
    private String model;
    private String make;
    private String color;
 //private Accident accidentDto;
   private Set<Motorist> motoristDto;

     //  public Accident getAccidentDto() {
     //  return accidentDto;    }

     // public Set<Motorist> getMotoristDto() {
     // return motoristDto;    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }
}

