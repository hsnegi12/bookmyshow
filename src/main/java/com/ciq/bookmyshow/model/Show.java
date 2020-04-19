package com.ciq.bookmyshow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Table(name="movie_show")
@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int screenNumber;
    private String dateTime;

    private String[] seatsBooked;

    @ManyToOne
    @JsonIgnore
    private Theater theater;

    @ManyToOne
    @JsonIgnore
    private Movie movie;

    public Show() {
    }
}
