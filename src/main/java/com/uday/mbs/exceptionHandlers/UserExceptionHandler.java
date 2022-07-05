package com.uday.mbs.exceptionHandlers;

import com.uday.mbs.exceptions.UserDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(value = UserDetailsNotFoundException.class)
    public ResponseEntity handleUserDetailsNotFoundException(){
        return new ResponseEntity("No such user details found", HttpStatus.BAD_REQUEST);
    }
}
