package com.ciq.bookmyshow.resource;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.bookmyshow.model.City;
import com.ciq.bookmyshow.model.Movie;
import com.ciq.bookmyshow.model.Show;
import com.ciq.bookmyshow.model.Theater;
import com.ciq.bookmyshow.repository.CityRepository;
import com.ciq.bookmyshow.repository.MovieRepository;
import com.ciq.bookmyshow.repository.ShowRepository;
import com.ciq.bookmyshow.repository.TheaterRepository;

@RestController
@RequestMapping(value = "/show")
public class ShowResource {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CityRepository cityRepository;

    @GetMapping(value = "/all")
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @GetMapping(value = "/all/{cityId}/{movieId}")
    public List<Show> getAllShowsInCityOfMovie(@PathVariable("cityId") final int cityId,
                                               @PathVariable("movieId") final int movieId) throws ParseException {
        List<Show> showList = showRepository.findAll();
        for(int i = 0 ; i < showList.size() ; ++i) {

            Show show = showList.get(i);
            Theater theater = show.getTheater();
            City city = theater.getCity();
            Optional<City> cityOptional = cityRepository.findById(cityId);

            Movie movie = show.getMovie();
            Optional<Movie> movieOptional = movieRepository.findById(movieId);

            if(!city.getCity().equals(cityOptional.get().getCity()) || !movie.getTitle().equals(movieOptional.get().getTitle())) {
                showList.remove(i);
            }
        }
        return showList;
    }

    @PostMapping(value = "add/{theaterId}/{movieId}")
    public void addShow(@PathVariable("theaterId") final int theaterId, @PathVariable("movieId") final int movieId,
                        @RequestBody final Show show) throws ParseException {
        Optional<Movie> movie = movieRepository.findById(movieId);
        Movie movieObject = movie.get();
        show.setMovie(movieObject);

        Optional<Theater> theater = theaterRepository.findById(theaterId);
        Theater theaterObject = theater.get();
        show.setTheater(theaterObject);

        showRepository.save(show);
    }

    @DeleteMapping(value = "/delete/{showId}")
    public void deleteShowByShowId(@PathVariable("showId") final int showId) {
        showRepository.deleteById(showId);
    }

}
