package com.mpek.ReservationSeat.dto;

import com.mpek.ReservationSeat.model.Movie;

public class MovieDTO {
    private long id;
    private String title;
    private int lenght;

    public MovieDTO() {
    }

    public MovieDTO(Movie m) {
        this.id = m.getId();
        this.title = m.getTitle();
        this.lenght = m.getLenght();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
