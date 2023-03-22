package com.springclass.firstproject.advisor;

import com.springclass.firstproject.exception.NotFoundException;
import com.springclass.firstproject.util.StanderdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StanderdResponse> handleNotFoundException(NotFoundException e){
             return new ResponseEntity<StanderdResponse>(
                     new StanderdResponse(404,"ERROR ERROR ERROR",e.getMessage()+"not get"), HttpStatus.NOT_FOUND
             );
    }
}
