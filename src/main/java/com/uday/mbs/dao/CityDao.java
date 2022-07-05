package com.uday.mbs.dao;

import com.uday.mbs.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao  extends JpaRepository<City,Integer> {
    public City findByCityName(String cityName);
    public City findByCityId(int cityId);
}
