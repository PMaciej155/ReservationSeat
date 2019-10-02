package com.mpek.ReservationSeat.exception;

public class BookedSeatException extends RuntimeException {
    public BookedSeatException(String message) {
        super(message);
    }
}
