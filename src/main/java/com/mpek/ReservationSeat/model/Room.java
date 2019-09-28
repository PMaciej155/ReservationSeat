package com.mpek.ReservationSeat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Seat> seats;
}
