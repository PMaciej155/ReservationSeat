package com.mpek.ReservationSeat.service;

import com.mpek.ReservationSeat.dto.ReservationDTO;
import com.mpek.ReservationSeat.dto.ScreeningDTO;
import com.mpek.ReservationSeat.dto.SeatDTO;
import com.mpek.ReservationSeat.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReservationServiceImpl implements IReservationService {
    @Autowired
    ReservationRepository reservationRepo;

    @Override
    public ReservationDTO createReservation(ScreeningDTO screeningDTO, Map<SeatDTO, String> seats) {
        return null;
    }
}
