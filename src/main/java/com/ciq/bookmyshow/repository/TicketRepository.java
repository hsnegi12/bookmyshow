package com.ciq.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.bookmyshow.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
