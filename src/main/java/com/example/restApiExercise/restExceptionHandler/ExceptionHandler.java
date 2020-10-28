package com.example.restApiExercise.restExceptionHandler;


import com.example.restApiExercise.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@SuppressWarnings({"unchecked", "rawTypes"})
@Slf4j
public class ExceptionHandler {
    //Vehicle Exception handler
   @org.springframework.web.bind.annotation.ExceptionHandler(VehicleNotFoundException.class)
      public ResponseEntity<VehicleNotFoundExceptionDetails> handleResourceNotFoundException(
            VehicleNotFoundException exception) {
           return new ResponseEntity<>(VehicleNotFoundExceptionDetails.builder()
         .timestamp(LocalDateTime.now())
         .status(String.valueOf(HttpStatus.NOT_FOUND.value()))
         .title("Resource Not Found")
         .detail(exception.getMessage())
         .developerMessage(exception.getClass().getName())
         .build(),HttpStatus.NOT_FOUND);
    }

    //Motorist Exception handler
    @org.springframework.web.bind.annotation.ExceptionHandler(MotoristNotFoundException.class)
    public ResponseEntity<MotoristNotFoundExceptionDetails> handleResourceNotFoundException(
            MotoristNotFoundException exception) {
        return new ResponseEntity<>(MotoristNotFoundExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .title("Resource Not Found")
                .detail(exception.getMessage())
                .developerMessage(exception.getClass().getName())
                .build(),HttpStatus.NOT_FOUND);
    }

    //Accident Exception handler
    @org.springframework.web.bind.annotation.ExceptionHandler(AccidentNotFoundException.class)
    public ResponseEntity<AccidentNotFoundExceptionDetails> handleResourceNotFoundException(
            AccidentNotFoundException exception) {
        return new ResponseEntity<>(AccidentNotFoundExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .title("Resource Not Found")
                .detail(exception.getMessage())
                .developerMessage(exception.getClass().getName())
                .build(),HttpStatus.NOT_FOUND);
    }






    // Validation Listener for Vehicle
    public ResponseEntity<VehicleNotValidDetails> handleVehicleNotValidException(MethodArgumentNotValidException exception){
           List<FieldError> fieldErrors=exception.getBindingResult().getFieldErrors();
           String field=fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
           String fieldMessage=fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
       return new ResponseEntity<>(VehicleNotValidDetails.builder()
               .timestamp(LocalDateTime.now())
               .status(String.valueOf(HttpStatus.NOT_FOUND.value()))
               .title("Not valid")
               .detail("Correct the fields")
               .developerMessage(exception.getClass().getName())
               .fields(field)
               .fieldMessage(fieldMessage)
               .build(),HttpStatus.BAD_REQUEST);
    }
}
