package com.example.employeemsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmployeeException(String message) {
        super(message);
    }

    public EmployeeException(String message, Throwable t) {
        super(message, t);
    }

}
