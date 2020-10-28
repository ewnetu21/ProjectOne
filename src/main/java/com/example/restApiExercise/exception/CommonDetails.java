package com.example.restApiExercise.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
 @Data
 @SuperBuilder
public class CommonDetails {
    protected String title;
    protected String status;
    protected String detail;
    protected LocalDateTime timestamp;
    protected String developerMessage;
}
