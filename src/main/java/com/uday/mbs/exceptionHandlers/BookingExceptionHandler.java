package com.uday.mbs.exceptionHandlers;

import com.uday.mbs.exceptions.BookingDetailsNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookingExceptionHandler {
    @ExceptionHandler(value = BookingDetailsNotFoundException.class)
    public ResponseEntity handleBookingDetailsNotFoundException(){
        return new ResponseEntity("No such booking exists", HttpStatus.BAD_REQUEST);
    }
}
