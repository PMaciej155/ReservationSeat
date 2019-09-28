package com.mpek.ReservationSeat.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    //    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "room_id")
//    private Room room;
    private int rowOfSeat;
    private int numberOfSeat;
    private boolean isTaken;
}
