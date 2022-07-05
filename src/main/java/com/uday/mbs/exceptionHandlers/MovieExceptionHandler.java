package com.uday.mbs.exceptionHandlers;

import com.uday.mbs.exceptions.MovieDetailsNotFoundException;
import com.uday.mbs.exceptions.MovieInvalidNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {

  @ExceptionHandler(value = MovieDetailsNotFoundException.class)
  public ResponseEntity handleMovieNotFoundException(){
    return new ResponseEntity("Movie ID not found ", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = MovieInvalidNameException.class)
  public ResponseEntity handleMovieNameInvalidException(){
    return new ResponseEntity("movie name passed is invalid",HttpStatus.BAD_REQUEST);
  }
}
