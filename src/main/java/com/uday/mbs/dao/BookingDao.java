package com.uday.mbs.dao;

import com.uday.mbs.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookingDao extends JpaRepository<Booking, Integer> {
}
