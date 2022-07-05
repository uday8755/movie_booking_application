package com.uday.mbs.validators;

import com.uday.mbs.entities.City;
import com.uday.mbs.exceptions.CityInvalidNameException;
import org.springframework.stereotype.Component;

@Component
public class CityValidator {
    public void validate(City city) throws CityInvalidNameException {
        if(city.getCityName()==null || city.getCityName().equals("")){
            throw new CityInvalidNameException();
        }
    }
}
