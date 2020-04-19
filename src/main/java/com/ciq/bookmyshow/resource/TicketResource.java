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

import com.ciq.bookmyshow.model.Show;
import com.ciq.bookmyshow.model.Ticket;
import com.ciq.bookmyshow.model.User;
import com.ciq.bookmyshow.repository.ShowRepository;
import com.ciq.bookmyshow.repository.TicketRepository;
import com.ciq.bookmyshow.repository.UserRepository;

@RestController
@RequestMapping(value = "/ticket")
public class TicketResource {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/all")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @PostMapping(value = "/add/{userId}/{showId}")
    public void persistTicketToDB(@PathVariable("userId") final int userId, @PathVariable("showId") final int showId,
                                @RequestBody final Ticket ticket) throws ParseException {

        Show show = setSeatsBooked(showId, ticket);
        showRepository.save(show);
        ticket.setShow(show);

        Optional<User> user = userRepository.findById(userId);
        User userObject = user.get();
        ticket.setUser(userObject);

        ticketRepository.save(ticket);
    }

    private Show setSeatsBooked(final int showId, final Ticket ticket) {

        Optional<Show> show = showRepository.findById(showId);
        Show showObject = show.get();
        String [] seatsBooked = ticket.getSeatsBooked();
        String [] showSeatsBooked = showObject.getSeatsBooked();
        int alreadyBookedCount = 0;
        if(showSeatsBooked != null) {
            alreadyBookedCount = showSeatsBooked.length;
        }
        int bookedCount = 0;
        if(seatsBooked != null) {
            bookedCount = seatsBooked.length;
        }
        String [] newSeatsBooked = new String [bookedCount + alreadyBookedCount];

        for(int i = 0 ; i < alreadyBookedCount ; ++i) {
            newSeatsBooked[i] = showSeatsBooked[i];
        }

        for(int i = 0 ; i < bookedCount ; ++i) {
            newSeatsBooked[alreadyBookedCount + i] = seatsBooked[i];
        }

        showObject.setSeatsBooked(newSeatsBooked);
        return showObject;
    }
}
