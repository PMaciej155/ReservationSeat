package com.mpek.ReservationSeat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;


    @ManyToOne(targetEntity = Room.class, fetch = FetchType.EAGER)
    private
    Room room;

    @OneToOne(targetEntity = Movie.class, fetch = FetchType.EAGER)
    private
    Movie movie;


    @Temporal(TemporalType.DATE)
    private
    Date dayOfScreening;

    @Temporal(TemporalType.TIME)
    private
    Date timeOfScreening;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
