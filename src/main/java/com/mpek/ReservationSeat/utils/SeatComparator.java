package com.mpek.ReservationSeat.utils;

import com.mpek.ReservationSeat.model.Seat;

import java.util.Comparator;

public class SeatComparator implements Comparator<Seat> {
    @Override
    public int compare(Seat o1, Seat o2) {
        Integer rowWarper = new Integer(o1.getRowOfSeat());
        int rowComparation = rowWarper.compareTo(o2.getRowOfSeat());
        if (rowComparation == 0) {
            Integer seatNumber = new Integer(o1.getNumberOfSeat());
            return seatNumber.compareTo(o2.getNumberOfSeat());
        }
        return rowComparation;
    }
}
