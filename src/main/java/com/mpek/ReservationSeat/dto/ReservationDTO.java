package com.mpek.ReservationSeat.dto;

public class ReservationDTO {
    String name;
    String surname;
    ReservationType reservationType;

    public enum ReservationType{
        ADULT,
        STUDENT,
        CHILD
    }
}
