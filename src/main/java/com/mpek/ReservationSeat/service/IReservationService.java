package com.mpek.ReservationSeat.service;


import com.mpek.ReservationSeat.exception.FreeGapSeatException;

import java.util.Map;

public interface IReservationService {

    Map<String, Object> createReservation(Integer id, String name, String surname, Map<Long, String> seats) throws FreeGapSeatException;
}
