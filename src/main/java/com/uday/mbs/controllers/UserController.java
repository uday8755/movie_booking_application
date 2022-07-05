package com.uday.mbs.controllers;

import com.uday.mbs.entities.Booking;
import com.uday.mbs.entities.MovieTheatre;
import com.uday.mbs.entities.User;
import com.uday.mbs.exceptions.*;
import com.uday.mbs.services.BookingService;
import com.uday.mbs.services.MovieTheatreService;
import com.uday.mbs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private MovieTheatreService movieTheatreService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity getUserBasedOnId(@PathVariable(name = "userId") int userId) throws UserDetailsNotFoundException {
        User user  = userService.getUserDetails(userId);
        return new ResponseEntity(user,HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUserDetails(@RequestBody User user) throws UserTypeDetailsNotFoundException, UserNameAlreadyExistsException {
        User savedUser = userService.acceptUserDetails(user);
        return new ResponseEntity(savedUser,HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}/{movieId}/{theatreId}")
    public ResponseEntity createUserBooking(@PathVariable(name = "userId") int userId,
                                            @PathVariable(name = "movieId") int movieId,
                                            @PathVariable(name = "theatreId") int theatreId) throws UserDetailsNotFoundException, MovieDetailsNotFoundException, TheatreDetailsNotFoundException, MovieTheatreDetailsNotFoundException {

        User user = userService.getUserDetails(userId);
        MovieTheatre movieTheatre = movieTheatreService.findByMovieMovieIdAndTheatreTheatreId(movieId,theatreId);
        Booking booking  = new Booking();
        booking.setMovieTheatre(movieTheatre);
        booking.setUser(user);
        Booking savedBooking= bookingService.acceptBookingDetails(booking);
        return new ResponseEntity(savedBooking,HttpStatus.CREATED);
    }


    @DeleteMapping(value  = "/{userId}/{bookingId}")
    public ResponseEntity deleteUserBookingById(@PathVariable(name = "userId") int userId,@PathVariable(name = "bookingId") int bookingId) throws UserDetailsNotFoundException, BookingDetailsNotFoundException {
        User savedUser = userService.getUserDetails(userId);
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity("BOOKING DELETED",HttpStatus.OK);
    }




}
