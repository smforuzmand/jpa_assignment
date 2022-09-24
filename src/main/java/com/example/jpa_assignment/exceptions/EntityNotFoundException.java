package com.example.jpa_assignment.exceptions;

public class EntityNotFoundException extends RuntimeException {


    public EntityNotFoundException(String message) {
        super(message);
    }
}
