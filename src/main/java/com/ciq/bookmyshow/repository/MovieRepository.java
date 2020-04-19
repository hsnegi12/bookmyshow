package com.ciq.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.bookmyshow.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
