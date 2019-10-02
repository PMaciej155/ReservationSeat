package com.mpek.ReservationSeat.dto;

import com.mpek.ReservationSeat.model.Screening;

import java.util.Date;

public class ScreeningDetailsDTO {
    private long id;
    private RoomDTO roomNumber;
    private MovieDTO movieDTO;
    private Date dayOfScreening;
    private Date timeOfScreening;

    public ScreeningDetailsDTO() {
    }

    public ScreeningDetailsDTO(Screening s) {
        this.id = s.getId();
        this.roomNumber = new RoomDTO(s.getRoom());
        this.movieDTO = new MovieDTO(s.getMovie());
        this.dayOfScreening = s.getDayOfScreening();
        this.timeOfScreening = s.getTimeOfScreening();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoomDTO getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(RoomDTO roomNumber) {
        this.roomNumber = this.roomNumber;
    }

    public MovieDTO getMovieDTO() {
        return movieDTO;
    }

    public void setMovieDTO(MovieDTO movieDTO) {
        this.movieDTO = movieDTO;
    }

    public Date getDayOfScreening() {
        return dayOfScreening;
    }

    public void setDayOfScreening(Date dayOfScreening) {
        this.dayOfScreening = dayOfScreening;
    }

    public Date getTimeOfScreening() {
        return timeOfScreening;
    }

    public void setTimeOfScreening(Date timeOfScreening) {
        this.timeOfScreening = timeOfScreening;
    }

}
