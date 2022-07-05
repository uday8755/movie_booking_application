package com.uday.mbs.validators;

import com.uday.mbs.dtos.MovieDTO;
import com.uday.mbs.exceptions.MovieInvalidNameException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MovieDTOValidator{
    public void validate(MovieDTO movieDTO) throws MovieInvalidNameException {
      if(movieDTO.getMovieName()== null || movieDTO.getMovieName().equals("")){
         throw new MovieInvalidNameException();
      }
    }
}
