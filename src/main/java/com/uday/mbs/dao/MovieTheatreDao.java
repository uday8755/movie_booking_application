package com.uday.mbs.dao;

import com.uday.mbs.entities.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheatreDao extends JpaRepository<MovieTheatre, Integer> {
    public MovieTheatre findByMovieMovieIdAndTheatreTheatreId(int movieId,int theatreId);
}
