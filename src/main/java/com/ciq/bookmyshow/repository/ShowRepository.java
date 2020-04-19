package com.ciq.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.bookmyshow.model.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
