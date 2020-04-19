package com.academy.administrative.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CommonsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgumentExceptionHandler(Exception e){
        return generateCommonExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> generateCommonExceptionResponse(String msg, HttpStatus httpStatus){
        ExceptionBodyResponse exceptionBodyResponse = new ExceptionBodyResponse();
        exceptionBodyResponse.setErrorCode(9999);
        exceptionBodyResponse.setMessage(msg);

        return new ResponseEntity<>(exceptionBodyResponse, httpStatus);
    }
}
