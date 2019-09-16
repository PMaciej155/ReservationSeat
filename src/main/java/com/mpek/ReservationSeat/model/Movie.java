package com.mpek.ReservationSeat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    public long id;
    String title;
    int lenght;
}
