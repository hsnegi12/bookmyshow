package com.ciq.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.bookmyshow.model.TheaterOwner;

public interface TheaterOwnerRepository extends JpaRepository<TheaterOwner, Integer> {
}
