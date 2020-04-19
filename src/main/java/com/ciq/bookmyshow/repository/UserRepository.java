package com.ciq.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.bookmyshow.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
