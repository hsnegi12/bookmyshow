package com.ciq.bookmyshow.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rowsInTheater;
    private int columnsInTheater;
    private String theaterName;

    @ManyToOne
    @JsonIgnore
    private TheaterOwner theaterOwner;

    @ManyToOne
    @JsonIgnore
    private City city;

    public Theater() {
    }
}
