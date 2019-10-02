package com.mpek.ReservationSeat.dto;


import com.mpek.ReservationSeat.model.Reservation;
import com.mpek.ReservationSeat.model.ReservationType;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class ReservationDTO {

    private long id;

    @Size(min = 3)
    private String name;

    @Size(min = 3)
    private String surname;

    private Date reservationDay;

    private Date exprationDay;

    private ScreeningDetailsDTO screeningDTO;

    private Map<SeatDTO, ReservationType> seatDTOs;
    private double cost;

    public ReservationDTO() {
    }

    public ReservationDTO(Reservation r) {
        this.id = r.getId();
        this.name = r.getName();
        this.surname = r.getSurname();

        this.reservationDay = r.getCreationDay();
        this.exprationDay = r.getExprationDay();
        this.screeningDTO = new ScreeningDetailsDTO(r.getScreening());
        this.seatDTOs = r.getSeats()
                .entrySet()
                .stream()
                .collect(Collectors
                        .toMap(entry -> new SeatDTO(entry.getKey()), entry -> entry.getValue()));
        this.setCost(r.getCostOfReservation());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public Date getReservationDay() {
        return reservationDay;
    }

    public void setReservationDay(Date reservationDay) {
        this.reservationDay = reservationDay;
    }

    public Date getExprationDay() {
        return exprationDay;
    }

    public void setExprationDay(Date exprationDay) {
        this.exprationDay = exprationDay;
    }

    public ScreeningDetailsDTO getScreeningDTO() {
        return screeningDTO;
    }

    public void setScreeningDTO(ScreeningDetailsDTO screeningDTO) {
        this.screeningDTO = screeningDTO;
    }

    public Map<SeatDTO, ReservationType> getSeatDTOs() {
        return seatDTOs;
    }

    public void setSeatDTOs(Map<SeatDTO, ReservationType> seatDTOs) {
        this.seatDTOs = seatDTOs;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
