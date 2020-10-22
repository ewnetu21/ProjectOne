package com.example.restApiExercise.dto;

import com.example.restApiExercise.Model.Vehicle;

import java.util.Set;

public class AccidentDto {
    private  int idDto;
    private  String nameDto;
    private String addressDto;
    private Set<Vehicle> vehicleDto;

    public Set<Vehicle> getVehicleDto() {
        return vehicleDto;
    }

    public int getIdDto() {
        return idDto;
    }

    public String getNameDto() {
        return nameDto;
    }

    public String getAddressDto() {
        return addressDto;
    }
}
