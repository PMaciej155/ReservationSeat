package com.mpek.ReservationSeat.service;


import com.mpek.ReservationSeat.dto.ReservationDTO;
import com.mpek.ReservationSeat.dto.ScreeningDTO;
import com.mpek.ReservationSeat.dto.SeatDTO;

import java.util.Map;

public interface IReservationService {

    ReservationDTO createReservation(ScreeningDTO screeningDTO, Map<SeatDTO, String> seats);
}
