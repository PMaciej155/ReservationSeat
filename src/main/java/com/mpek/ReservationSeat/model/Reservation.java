package com.mpek.ReservationSeat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    public long id;
    String name;
    String surname;
    ReservationType reservationType;
    @Temporal(TemporalType.TIMESTAMP)
    Date creationDay;

    @Temporal(TemporalType.TIMESTAMP)
    Date exprationDay;


    @OneToOne(targetEntity = Reservation.class, fetch = FetchType.EAGER)
    Screening screening;

//    @ManyToOne(targetEntity=Seat.class)
//    Map<Seat, ReservationType> seats;

    public enum ReservationType {
        ADULT,
        STUDENT,
        CHILD
    }
}
