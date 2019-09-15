package com.mpek.ReservationSeat.service;

import com.mpek.ReservationSeat.dto.ScreeningDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService{

    @Override
    public List<String> showScreenings(Date startInterval, Date endInterval) {
        return null;
    }

    @Override
    public ScreeningDTO showDetailsScreening(Date dateOfScreening, String titleOfMovie) {
        return null;
    }
}
