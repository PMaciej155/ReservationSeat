package com.mpek.ReservationSeat.dto;

import com.mpek.ReservationSeat.model.Seat;

public class SeatDTO {
    private long id;
    private int row;
    private int number;

    public SeatDTO() {
    }

    public SeatDTO(Seat s) {
        this.id = s.getId();
        this.number = s.getNumberOfSeat();
        this.row = s.getRowOfSeat();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
