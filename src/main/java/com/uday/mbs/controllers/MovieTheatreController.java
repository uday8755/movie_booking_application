package com.uday.mbs.controllers;

import com.uday.mbs.entities.Movie;
import com.uday.mbs.entities.MovieTheatre;
import com.uday.mbs.entities.Theatre;
import com.uday.mbs.exceptions.MovieDetailsNotFoundException;
import com.uday.mbs.exceptions.TheatreDetailsNotFoundException;
import com.uday.mbs.services.MovieService;
import com.uday.mbs.services.MovieTheatreService;
import com.uday.mbs.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieTheatres")
public class MovieTheatreController {
    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieTheatreService movieTheatreService;

    @PostMapping(value = "/{movieId}/{theatreId}")
    public ResponseEntity createMovieTheatre(@PathVariable(name = "movieId") int movieId,
                                             @PathVariable(name = "theatreId") int theatreId) throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {
        Movie savedMovie = movieService.getMovieDetails(movieId);
        Theatre savedTheatre   = theatreService.getTheatreDetails(theatreId);
        MovieTheatre movieTheatre = new MovieTheatre();
        movieTheatre.setMovie(savedMovie);
        movieTheatre.setTheatre(savedTheatre);
        MovieTheatre savedMovieTheatre = movieTheatreService.acceptMovieTheatreDetails(movieTheatre);
        return new ResponseEntity(savedMovieTheatre, HttpStatus.OK);
    }

}
