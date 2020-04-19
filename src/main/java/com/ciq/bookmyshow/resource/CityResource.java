package com.ciq.bookmyshow.resource;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.bookmyshow.model.City;
import com.ciq.bookmyshow.repository.CityRepository;

@RestController
@RequestMapping(value = "/city")
public class CityResource {

    @Autowired
    CityRepository cityRepository;

    @GetMapping(value = "/all")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping(value = "/{cityId}")
    public City getCityByCityId(@PathVariable("cityId") final int cityId) throws ParseException {
        return cityRepository.findById(cityId).get();
    }

    @PostMapping(value = "/add")
    public void persistCityToDB(@RequestBody final City city) {
        cityRepository.save(city);
    }
}
