package pl.cango.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class GlobalExceptionHandler {
    // exception hanlder wird (500)
    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Internal Server Error" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // exception  handler  (np. IllegalArgumentException)
    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
