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

import com.ciq.bookmyshow.model.TheaterOwner;
import com.ciq.bookmyshow.repository.TheaterOwnerRepository;

@RestController
@RequestMapping(value = "/theaterOwner")
public class TheaterOwnerResource {

    @Autowired
    TheaterOwnerRepository theaterOwnerRepository;

    @GetMapping(value = "/all")
    public List<TheaterOwner> getAllTheaterOwners() {
        return theaterOwnerRepository.findAll();
    }

    @GetMapping(value = "/{ownerId}")
    public TheaterOwner getTheaterOwnerByOwnerId(@PathVariable("ownerId") final int ownerId) throws ParseException {
        return theaterOwnerRepository.findById(ownerId).get();
    }

    @PostMapping(value = "/add")
    public void addTheaterOwner(@RequestBody final TheaterOwner theaterOwner) {
        theaterOwnerRepository.save(theaterOwner);
    }
}
