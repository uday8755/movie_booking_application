package com.uday.mbs.controllers;

import com.uday.mbs.entities.City;
import com.uday.mbs.entities.Theatre;
import com.uday.mbs.exceptions.CityDetailsNotFoundException;
import com.uday.mbs.exceptions.CityInvalidNameException;
import com.uday.mbs.exceptions.TheatreDetailsNotFoundException;
import com.uday.mbs.services.CityService;
import com.uday.mbs.services.TheatreService;
import com.uday.mbs.validators.CityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private CityValidator cityValidator;

    @GetMapping("/greetings")
    public ResponseEntity helloWorld(){
        return new ResponseEntity("hello people", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCities(){
        List<City> cityList = cityService.getAllCityDetails();
        return new ResponseEntity(cityList,HttpStatus.OK);
    }

    @GetMapping(value = "/{cityName}")
    public ResponseEntity getCityBasedOnId(@PathVariable(name = "cityName") String cityName) throws CityDetailsNotFoundException {
        City city = cityService.getCityDetailsByCityName(cityName);
        return new ResponseEntity(city,HttpStatus.OK);
    }

    @GetMapping(path = "/{cityName}/theatres")
    public ResponseEntity getAllTheatres(@PathVariable(name = "cityName") String cityName) throws CityDetailsNotFoundException {
        City city = cityService.getCityDetailsByCityName(cityName);
        List<Theatre> theatreList = city.getTheatres();
        return new ResponseEntity(theatreList,HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeCityName(@RequestBody City city) throws CityInvalidNameException {
       cityValidator.validate(city);
       City savedCity = cityService.acceptCityDetails(city);
       return new ResponseEntity(savedCity,HttpStatus.OK);
    }

    @PutMapping(path = "/{cityName}/{theatreId}")
    private ResponseEntity addTheatreToCity(@PathVariable(name = "cityName") String cityName,
                                            @PathVariable(name = "theatreId") int theatreId) throws TheatreDetailsNotFoundException, CityDetailsNotFoundException {
        Theatre theatre = theatreService.getTheatreDetails(theatreId);
        City city = cityService.getCityDetailsByCityName(cityName);
        city.setSingleTheatre(theatre);
        return new ResponseEntity(city,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{cityName}")
    public ResponseEntity deleteCity(@PathVariable(name = "cityName") String cityName) throws CityDetailsNotFoundException {
        City city = cityService.getCityDetailsByCityName(cityName);
        cityService.deleteCity(city.getCityId());
        return new ResponseEntity("DELETED",HttpStatus.OK);
    }



}
