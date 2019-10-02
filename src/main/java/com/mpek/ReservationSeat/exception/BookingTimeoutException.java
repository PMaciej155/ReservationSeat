package com.mpek.ReservationSeat.exception;

public class BookingTimeoutException extends RuntimeException {
    public BookingTimeoutException(String errorMessage) {
        super(errorMessage);
    }
}
