package com.mpek.ReservationSeat.dto;

import com.mpek.ReservationSeat.model.Room;

import java.util.Map;
import java.util.stream.Collectors;

public class RoomDTO {
    private long id;
    private int number;
    private Map<Long, SeatDTO> seats;

    public RoomDTO() {
    }

    public RoomDTO(Room r) {
        this.id = r.getId();
        this.number = r.getRoomNumber();
        this.seats = r.getSeats()
                .entrySet()
                .stream()
                .collect(Collectors
                        .toMap(Map.Entry::getKey, entry -> new SeatDTO(entry.getValue())));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Map<Long, SeatDTO> getSeats() {
        return seats;
    }

    public void setSeats(Map<Long, SeatDTO> seats) {
        this.seats = seats;
    }
}
