package com.apiexamples.examples.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //This annotation is applied to a class that will handle global exceptions
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class) // any resourcenotfound exception will come to this class
    public ResponseEntity<String> handleResourceNotFound( ResourceNotFound ex){
     return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){

        return  new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
