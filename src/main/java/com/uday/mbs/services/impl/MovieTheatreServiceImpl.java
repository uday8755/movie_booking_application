package com.uday.mbs.services.impl;

import com.uday.mbs.dao.MovieTheatreDao;
import com.uday.mbs.entities.MovieTheatre;
import com.uday.mbs.exceptions.MovieDetailsNotFoundException;
import com.uday.mbs.exceptions.MovieTheatreDetailsNotFoundException;
import com.uday.mbs.exceptions.TheatreDetailsNotFoundException;
import com.uday.mbs.services.MovieService;
import com.uday.mbs.services.MovieTheatreService;
import com.uday.mbs.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieTheatreServiceImpl implements MovieTheatreService {
    @Autowired
    private MovieTheatreDao movieTheatreDao;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieService movieService;

    @Override
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre)
            throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {
        movieService.getMovieDetails(movieTheatre.getMovie().getMovieId());
        theatreService.getTheatreDetails(movieTheatre.getTheatre().getTheatreId());
        return movieTheatreDao.save(movieTheatre);
    }

    @Override
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException {
        return movieTheatreDao.findById(id)
                .orElseThrow(
                        () -> new MovieTheatreDetailsNotFoundException("MovieTheatre not found by id: " + id)
                );
    }

    @Override
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException {
        MovieTheatre movieTheatre = getMovieTheatreDetails(id);
        movieTheatreDao.delete(movieTheatre);
        return true;
    }

    @Override
    public List<MovieTheatre> getAllMovieTheatreDetails() {
        return movieTheatreDao.findAll();
    }

    @Override
    public MovieTheatre findByMovieMovieIdAndTheatreTheatreId(int movieId,int theatreId) throws MovieDetailsNotFoundException,TheatreDetailsNotFoundException{
        MovieTheatre movieTheatre = movieTheatreDao.findByMovieMovieIdAndTheatreTheatreId(movieId,theatreId);
        return movieTheatre;
    }
}
