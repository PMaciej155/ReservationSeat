package com.mpek.ReservationSeat.service;

import com.mpek.ReservationSeat.dto.ScreeningDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningServiceImpl implements IScreeningService {

    @Override
    public List<String> showScreenings(Integer startInterval, Integer endInterval) {
        return null;
    }

    @Override
    public ScreeningDTO showDetailsScreening(Integer dateOfScreening, String titleOfMovie) {
        return null;
    }
}
