package com.mpek.ReservationSeat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Screening {
    @Id
    @GeneratedValue
    public long id;
    Room room;

    Movie movie;

    Integer startTimeOfScreening;
}
