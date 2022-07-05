package com.uday.mbs.dao;

import com.uday.mbs.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDao extends JpaRepository<Movie,Integer> {
    public List<Movie> findByMovieName(String movieName);
    public List<Movie> findByDuration(int x);
    }



