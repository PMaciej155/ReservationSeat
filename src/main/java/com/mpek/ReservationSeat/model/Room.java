package com.mpek.ReservationSeat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;


@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    private int roomNumber;

    @ElementCollection
    private Map<Long, Seat> seats;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<Long, Seat> getSeats() {
        return seats;
    }

    public void setSeats(Map<Long, Seat> seats) {
        this.seats = seats;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
