package com.mpek.ReservationSeat.exception;

public class NoSeatFoundException extends RuntimeException {
    public NoSeatFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
