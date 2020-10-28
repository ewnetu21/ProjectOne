package com.example.restApiExercise.dto;

import com.example.restApiExercise.Model.Vehicle;

public class MotoristDto {
    private int licence;
    private String firstname;
    private String lastname;
    private int age;
    //private Vehicle vehicleDto;

    public int getLicence() {
        return licence;
    }

    public String getFirstname() {
        return firstname;
    }

    //public Vehicle getVehicleDto() {
        //return vehicleDto;
    //}

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}
