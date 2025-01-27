package pl.cango.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.ServiceNotFoundException;

@RestControllerAdvice
class AliasControllerAdvice {

    @ExceptionHandler(ServiceNotFoundException.class)
    ResponseEntity<String> handleException(ServiceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
