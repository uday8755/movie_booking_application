package com.uday.mbs.services;

import com.uday.mbs.entities.MovieTheatre;
import com.uday.mbs.entities.Theatre;
import com.uday.mbs.exceptions.MovieDetailsNotFoundException;
import com.uday.mbs.exceptions.MovieTheatreDetailsNotFoundException;
import com.uday.mbs.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface MovieTheatreService {
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieDetailsNotFoundException,
            TheatreDetailsNotFoundException;
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException;
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException;
    public List<MovieTheatre> getAllMovieTheatreDetails();
    public MovieTheatre findByMovieMovieIdAndTheatreTheatreId(int movieId,int theatreId) throws MovieDetailsNotFoundException,TheatreDetailsNotFoundException;

}
