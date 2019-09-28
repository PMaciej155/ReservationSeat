package com.mpek.ReservationSeat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    public long id;


    @OneToOne(targetEntity = Room.class, fetch = FetchType.EAGER)
    Room room;

    @OneToOne(targetEntity = Movie.class, fetch = FetchType.EAGER)
    Movie movie;

    @Temporal(TemporalType.DATE)
    Date dayOfScreening;

    @Temporal(TemporalType.TIME)
    Date timeOfScreening;

}
