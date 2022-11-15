package com.example.jpa_assignment.exceptions;


import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Setter
@Getter
public class APIErrorViolation extends APIError{

    private List<Violation> violations;

    public APIErrorViolation(Integer statusCode, String statusText, String message, List<Violation> violations) {
        super(statusCode, statusText, message);
        this.violations = violations;
    }


}
