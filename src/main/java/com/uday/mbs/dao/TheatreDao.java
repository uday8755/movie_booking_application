package com.uday.mbs.dao;

import com.uday.mbs.entities.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreDao  extends JpaRepository<Theatre,Integer> {
    public Theatre findByTheatreName(String theatreName);
    public List<Theatre> findByTicketPriceLessThan(float price);
    public List<Theatre> findByTheatreNameContaining(String theatreName);
}
