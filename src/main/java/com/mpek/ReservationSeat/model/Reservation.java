package com.mpek.ReservationSeat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Map;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    public long id;
    String name;
    String surname;
    ReservationType reservationType;
    Screening screening;
    Map<Seat, ReservationType> seats;

    public enum ReservationType {
        ADULT,
        STUDENT,
        CHILD
    }
}
