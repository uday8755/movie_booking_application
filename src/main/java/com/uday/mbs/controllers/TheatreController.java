package com.uday.mbs.controllers;

import com.uday.mbs.entities.City;
import com.uday.mbs.entities.Theatre;
import com.uday.mbs.exceptions.CityDetailsNotFoundException;
import com.uday.mbs.exceptions.TheatreDetailsNotFoundException;
import com.uday.mbs.services.CityService;
import com.uday.mbs.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity getAllTheatres(){
        List<Theatre> theatreList = theatreService.getAllTheatreDetails();
        return new ResponseEntity(theatreList, HttpStatus.OK);
    }

    @GetMapping(value = "/{theatreId}")
    public ResponseEntity getTheatreBasedOnId(@PathVariable(name = "theatreId") int theatreId) throws TheatreDetailsNotFoundException {
        Theatre theatre = theatreService.getTheatreDetails(theatreId);
        return new ResponseEntity(theatre,HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveTheatreDetails(@RequestBody Theatre theatre){
        Theatre savedTheatre = theatreService.acceptTheatreDetails(theatre);
        return new ResponseEntity(savedTheatre,HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/{theatreId}/{cityId}")
    public ResponseEntity updateTheatreDetails(@PathVariable(name = "theatreId")
                                                           int theatreId,@PathVariable(name = "cityId") int cityId) throws CityDetailsNotFoundException, TheatreDetailsNotFoundException {
        Theatre theatre = theatreService.getTheatreDetails(theatreId);
        City city  = cityService.getCityDetails(cityId);
        theatre.setCity(city);
        Theatre savedTheatre = theatreService.acceptTheatreDetails(theatre);
        return new ResponseEntity(savedTheatre,HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{theatreId}")
    public ResponseEntity deleteATheatreById(@PathVariable(name = "theatreId") int theatreId) throws TheatreDetailsNotFoundException {
        theatreService.deleteTheatre(theatreId);
        return new ResponseEntity("DELETED",HttpStatus.OK);
    }


}
