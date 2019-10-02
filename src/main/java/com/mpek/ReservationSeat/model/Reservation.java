package com.mpek.ReservationSeat.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private String surname;

    @Temporal(TemporalType.TIMESTAMP)
    private
    Date creationDay;

    @Temporal(TemporalType.TIMESTAMP)
    private
    Date exprationDay;


    @OneToOne(targetEntity = Screening.class, fetch = FetchType.EAGER)
    private
    Screening screening;

    @ElementCollection
    private
    Map<Seat, ReservationType> seats;

    private double costOfReservation;


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


    public Date getCreationDay() {
        return creationDay;
    }

    public void setCreationDay(Date creationDay) {
        this.creationDay = creationDay;
    }

    public Date getExprationDay() {
        return exprationDay;
    }

    public void setExprationDay(Date exprationDay) {
        this.exprationDay = exprationDay;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }


    public Map<Seat, ReservationType> getSeats() {
        return seats;
    }

    public void setSeats(Map<Seat, ReservationType> seats) {
        this.seats = seats;
    }

    public double getCostOfReservation() {
        return costOfReservation;
    }

    public void setCostOfReservation(double costOfReservation) {
        this.costOfReservation = costOfReservation;
    }
}


