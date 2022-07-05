package com.uday.mbs.services;

import com.uday.mbs.entities.Booking;
import com.uday.mbs.exceptions.BookingDetailsNotFoundException;
import com.uday.mbs.exceptions.MovieTheatreDetailsNotFoundException;
import com.uday.mbs.exceptions.UserDetailsNotFoundException;

import java.util.List;
public interface BookingService {
    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException,
            UserDetailsNotFoundException;
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException;
    public List<Booking> getAllBookingDetails();
}
