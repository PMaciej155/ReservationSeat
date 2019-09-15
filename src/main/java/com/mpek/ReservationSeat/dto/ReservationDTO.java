package com.mpek.ReservationSeat.dto;

public class ReservationDTO {
    String name;
    String surname;
    ReservationTypeDTO reservationTypeDTO;
    ScreeningDTO screening;
    SeatDTO seat;

    public enum ReservationTypeDTO{
        ADULT,
        STUDENT,
        CHILD
    }
}
