package com.mpek.ReservationSeat.service;

import com.mpek.ReservationSeat.dto.ScreeningDTO;

import java.util.List;

public interface IScreeningService {
    List<String> showScreenings(Integer startInterval, Integer endInterval);

    ScreeningDTO showDetailsScreening(Integer dateOfScreening, String titleOfMovie);
}
