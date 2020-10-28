package com.example.restApiExercise.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class VehicleNotValidDetails extends CommonDetails{
    private String fields;
    private String fieldMessage;
}
