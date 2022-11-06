package com.example.jpa_assignment.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Violation {

    private String fieldName;
    private String message;


}
