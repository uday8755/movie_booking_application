package com.uday.mbs.exceptionHandlers;

import com.uday.mbs.exceptions.MovieDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieTheatreExceptionHandler {
    @ExceptionHandler(value = MovieDetailsNotFoundException.class)
    public ResponseEntity handleMovieTheatreDetailsNotFoundException(){
        return new ResponseEntity("No such movie available in the given theatre", HttpStatus.BAD_REQUEST);
    }
}
