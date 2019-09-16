package com.mpek.ReservationSeat.dto;


import java.util.Map;

public class ReservationDTO {
    private long id;
    private String name;
    private String surname;
    private ReservationTypeDTO reservationTypeDTO;
    private ScreeningDTO screeningDTO;
    private Map<SeatDTO, ReservationTypeDTO> seatDTOs;

    public enum ReservationTypeDTO{
        ADULT,
        STUDENT,
        CHILD
    }
}
