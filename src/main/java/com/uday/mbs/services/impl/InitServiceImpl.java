package com.uday.mbs.services.impl;

import com.uday.mbs.dao.*;
import com.uday.mbs.entities.City;
import com.uday.mbs.entities.Movie;
import com.uday.mbs.entities.Status;
import com.uday.mbs.entities.UserType;
import com.uday.mbs.services.CityService;
import com.uday.mbs.services.InitService;
import com.uday.mbs.services.MovieService;
import com.uday.mbs.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {
    @Autowired
    private CityService cityService ;

    @Autowired
    private UserTypeDao userTypeDao ;

    @Autowired
    private StatusService statusService ;

    @Autowired
    private MovieService movieService ;

    @Autowired
    private UserDao userDao ;

    @Autowired
    private TheatreDao theatreDao ;

    @Autowired
    private MovieTheatreDao movieTheatreDao ;

    @Autowired
    private BookingDao bookingDao ;

    /**
     * Cooking data
     *
     * Define and initialize together
     *
     * int i ; -- defining a variable
     * i=5 ; -- assigning a value
     *
     *
     * int i = 5 ; -- define and assign at the same time
     */
    List<Status> statuses = Arrays.asList(new Status("UPCOMING") ,
            new Status("RELEASED"),new Status("BLOCKED"));


    @Override
    public void init() {
        /**
         * Write the logic to store date inside the database in different tables
         */

        /**
         * Add cities
         */
        createCities();


        /**
         * Add User Types
         */

        createUserTypes();

        /**
         * Add Statuses
         */
        createStatuses();

        /**
         * Add Movies
         */

        createMovies();

        /**
         * Add Users
         *
         */


        /**
         * Add theatres
         */

        /**
         * MovieTheatres
         */

        /**
         * Booking
         */

    }

    private void createMovies() {
        Movie movie1 = new Movie();
        movie1.setMovieName("Movie1_Name");
        movie1.setTrailerUrl("Movie1_T_URL");
        movie1.setStatus(statuses.get(1));
        movie1.setMovieDescription("Movie1 description");
        movie1.setDuration(120);
        movie1.setTrailerUrl("Movie1_T_URL");
        movie1.setReleaseDate(LocalDateTime.of(2018,4,27,5,30));
        movie1.setCoverPhotoUrl("Movie1_C_URL");
        movieService.acceptMovieDetails(movie1);
    }

    private void createStatuses() {

        statuses.forEach(status -> {
            statusService.acceptStatusDetails(status);
        });
    }

    private void createUserTypes() {
        List<UserType> userTypes = new ArrayList<>();
        userTypes.add(new UserType("Customer"));
        userTypes.add(new UserType("Admin"));

        userTypes.forEach(userType ->  {
            userTypeDao.save(userType);
        });
    }

    private void createCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Patna"));
        cities.add(new City("Bangalore"));
        cities.add(new City("Kolkata"));
        cities.add(new City("Mumbai"));

        cities.forEach(city -> cityService.acceptCityDetails(city));
    }
}
