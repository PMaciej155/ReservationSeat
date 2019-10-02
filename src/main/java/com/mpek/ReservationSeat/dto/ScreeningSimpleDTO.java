package com.mpek.ReservationSeat.dto;

import com.mpek.ReservationSeat.model.Screening;

import java.util.Date;

public class ScreeningSimpleDTO {
    private Long id;
    private String movieTitle;
    private Date dayOfScreening;
    private Date timeOfScreening;

    public ScreeningSimpleDTO() {
    }

    public ScreeningSimpleDTO(Screening screening) {
        this.setId(screening.getId());
        this.movieTitle = screening.getMovie().getTitle();
        this.dayOfScreening = screening.getDayOfScreening();
        this.timeOfScreening = screening.getTimeOfScreening();
    }


    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
