package com.kurmi.todos.others;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(NotFoundException exc) {
        CustomErrorResponse error = new CustomErrorResponse();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(Exception exc) {
        CustomErrorResponse error = new CustomErrorResponse();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setErrorMessage("Not a valid id");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
