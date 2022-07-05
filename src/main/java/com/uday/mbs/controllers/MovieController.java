package com.uday.mbs.controllers;

import com.uday.mbs.dtos.MovieDTO;
import com.uday.mbs.entities.Movie;
import com.uday.mbs.exceptions.MovieDetailsNotFoundException;
import com.uday.mbs.exceptions.MovieInvalidNameException;
import com.uday.mbs.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uday.mbs.validators.MovieDTOValidator;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieDTOValidator movieDTOValidator;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/greetings")
    public ResponseEntity helloWorld(){
         return new ResponseEntity("hello people", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllMovies(){
       List<Movie> movies = movieService.getAllMoviesDetails();
       List<MovieDTO> movieDTOS = new ArrayList<>();
       for(Movie movie: movies){
           movieDTOS.add(convertToMovieDTO(movie));
       }
       return new ResponseEntity(movieDTOS,HttpStatus.OK);
    }

    @GetMapping(value = "/{movieId}")
    public ResponseEntity getMovieBasedOnId(@PathVariable(name="movieId") int movieId) throws MovieDetailsNotFoundException {
        Movie movie = movieService.getMovieDetails(movieId);
        MovieDTO movieDTO = convertToMovieDTO(movie);
        return new ResponseEntity(movieDTO,HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMovie(@RequestBody MovieDTO movieDTO) throws MovieInvalidNameException {
        movieDTOValidator.validate(movieDTO);
       Movie movie = modelMapper.map(movieDTO,Movie.class);
       Movie savedMovie = movieService.acceptMovieDetails(movie);
       MovieDTO response = convertToMovieDTO(savedMovie);
       return new ResponseEntity(response,HttpStatus.CREATED);
    }

    @PutMapping(value = "/{movieId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMovieDetails(@RequestBody MovieDTO movieDTO,@PathVariable(name = "movieId") int movieId) throws MovieDetailsNotFoundException {
       Movie storedMovie = movieService.getMovieDetails(movieId);
       Movie updated = modelMapper.map(movieDTO,Movie.class);
       Movie saved = movieService.updateMovieDetails(movieId,updated);
       MovieDTO savedUpdate = modelMapper.map(saved,MovieDTO.class);
       return new ResponseEntity(savedUpdate,HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value="/movieId")
    public ResponseEntity deleteMovie(@PathVariable(name = "movieId") int movieId) throws MovieDetailsNotFoundException {
        movieService.deleteMovie(movieId);
        return new ResponseEntity("DELETED",HttpStatus.OK);
    }
    private MovieDTO convertToMovieDTO(Movie movie){
        MovieDTO movieDTO = modelMapper.map(movie,MovieDTO.class);
        return movieDTO;
    }



}
