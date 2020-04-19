package com.ciq.bookmyshow.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.bookmyshow.model.Movie;
import com.ciq.bookmyshow.repository.MovieRepository;

@RestController
@RequestMapping(value = "/movie")
public class MovieResource {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping(value = "/all")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping(value = "/add")
    public void addMovieToDB(@RequestBody final Movie movie) {
        movieRepository.save(movie);
    }
}
