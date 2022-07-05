package com.uday.mbs.exceptionHandlers;

import com.uday.mbs.exceptions.CityDetailsNotFoundException;
import com.uday.mbs.exceptions.CityInvalidNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CityExceptionHandler {
    @ExceptionHandler(value= CityDetailsNotFoundException.class)
    public ResponseEntity handleCityDetailsNotFoundException(){
        return new ResponseEntity("City details being passed are incorrect", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CityInvalidNameException.class)
    public ResponseEntity handleCityNameException(){
        return new ResponseEntity("Enter a valid City name",HttpStatus.BAD_REQUEST);
    }


}
