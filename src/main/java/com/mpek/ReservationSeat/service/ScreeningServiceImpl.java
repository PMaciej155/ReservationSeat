package com.mpek.ReservationSeat.service;

import com.mpek.ReservationSeat.dto.ScreeningDTO;
import com.mpek.ReservationSeat.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements IScreeningService {

    @Autowired
    ScreeningRepository screeningRepo;

    @Override
    public List<ScreeningDTO> showScreenings(Integer startInterval, Integer endInterval) {
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMddHHmm");
        try {
            Date date = originalFormat.parse(startInterval.toString());
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public ScreeningDTO showDetailsScreening(Integer dateOfScreening, String titleOfMovie) {
        return null;
    }
}
