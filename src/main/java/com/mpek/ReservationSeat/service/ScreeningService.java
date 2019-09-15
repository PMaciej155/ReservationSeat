package com.mpek.ReservationSeat.service;

import com.mpek.ReservationSeat.dto.ScreeningDTO;

import java.util.Date;
import java.util.List;

public interface ScreeningService {
    public List<String> showScreenings(Date startInterval, Date endInterval);

    public ScreeningDTO showDetailsScreening(Date dateOfScreening, String titleOfMovie);
}
