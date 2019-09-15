package com.mpek.ReservationSeat.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Seat {

    @Id
    @GeneratedValue
    private long id;
    private String row;
    private int number;
}
