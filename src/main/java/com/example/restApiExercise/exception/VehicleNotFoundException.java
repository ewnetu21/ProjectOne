package com.example.restApiExercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
@ResponseStatus(value = HttpStatus.NOT_FOUND) //if this is not present the error will be 500 internal server error
public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException(String message) {
       super(message);
    }



}
