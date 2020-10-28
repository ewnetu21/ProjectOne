package com.example.restApiExercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccidentNotFoundException extends RuntimeException{
    public AccidentNotFoundException(String message){
        super(message);
    }
}
