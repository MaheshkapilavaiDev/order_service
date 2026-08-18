package com.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Map<String, Object>>
    handleOrderNotFound(OrderNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "status", 404,
                        "message", ex.getMessage()
                ));
    }

    @ExceptionHandler(UserServiceUnavailableException.class)
    public ResponseEntity<Map<String, Object>>
    handleUserServiceUnavailable(
            UserServiceUnavailableException ex) {

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "status", 503,
                        "message", ex.getMessage()
                ));
    }
}