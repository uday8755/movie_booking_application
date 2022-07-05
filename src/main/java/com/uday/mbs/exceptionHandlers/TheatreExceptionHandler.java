package com.uday.mbs.exceptionHandlers;

import com.uday.mbs.exceptions.TheatreDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TheatreExceptionHandler {

    @ExceptionHandler(value = TheatreDetailsNotFoundException.class)
    public ResponseEntity handleTheatreDetailsNotFound(){
        return new ResponseEntity("No such theatre", HttpStatus.BAD_REQUEST);
    }
}
