package com.mpek.ReservationSeat.service;

import com.mpek.ReservationSeat.dto.ReservationDTO;
import com.mpek.ReservationSeat.dto.ScreeningDTO;
import com.mpek.ReservationSeat.dto.SeatDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReservationServiceImpl implements IReservationService {
    @Override
    public ReservationDTO createReservation(ScreeningDTO screeningDTO, Map<SeatDTO, String> seats) {
        return null;
    }
}
