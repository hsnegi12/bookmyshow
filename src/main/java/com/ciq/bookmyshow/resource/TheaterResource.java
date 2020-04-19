package com.ciq.bookmyshow.resource;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.bookmyshow.model.City;
import com.ciq.bookmyshow.model.Show;
import com.ciq.bookmyshow.model.Theater;
import com.ciq.bookmyshow.model.TheaterOwner;
import com.ciq.bookmyshow.repository.CityRepository;
import com.ciq.bookmyshow.repository.ShowRepository;
import com.ciq.bookmyshow.repository.TheaterOwnerRepository;
import com.ciq.bookmyshow.repository.TheaterRepository;

@RestController
@RequestMapping(value = "/theater")
public class TheaterResource {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    TheaterOwnerRepository theaterOwnerRepository;

    @GetMapping(value = "/all")
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    @PostMapping(value = "/add/{cityId}/{ownerId}")
    public void addTheaterToDB(@PathVariable("cityId") final int cityId, @PathVariable("ownerId") final int ownerId,
                               @RequestBody final Theater theater) throws ParseException {

        Optional<City> city = cityRepository.findById(cityId);
        City cityObject = city.get();
        theater.setCity(cityObject);

        Optional<TheaterOwner> theaterOwner = theaterOwnerRepository.findById(ownerId);
        TheaterOwner theaterOwnerObject = theaterOwner.get();
        theater.setTheaterOwner(theaterOwnerObject);

        theaterRepository.save(theater);
    }

}
