package com.mpek.ReservationSeat.service;


import com.mpek.ReservationSeat.dto.ScreeningDetailsDTO;
import com.mpek.ReservationSeat.dto.ScreeningSimpleDTO;

import java.util.List;

public interface IScreeningService {
    List<ScreeningSimpleDTO> showScreenings(Integer dayOfScreening, Integer startInterval, Integer endInterval) throws Exception;

    List<ScreeningSimpleDTO> showAllScreenings();

    ScreeningDetailsDTO showDetailsScreening(Long idOfScreening) throws Exception;
}
