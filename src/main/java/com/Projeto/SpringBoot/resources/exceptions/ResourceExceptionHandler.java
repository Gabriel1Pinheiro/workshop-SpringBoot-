package com.Projeto.SpringBoot.resources.exceptions;

import com.Projeto.SpringBoot.services.exceptions.DatabaseException;
import com.Projeto.SpringBoot.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


// A classe ResourceExceptionHandler é um componente do Spring que trata globalmente exceções no aplicativo.

// A anotação @ControllerAdvice contém métodos específicos para lidar com diferentes tipos de exceções.
@ControllerAdvice
public class ResourceExceptionHandler {

    // Trata exceções do tipo ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resouceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    // Trata exceções do tipo DatabaseException.
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
