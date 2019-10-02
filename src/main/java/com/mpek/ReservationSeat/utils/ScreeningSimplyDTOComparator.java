package com.mpek.ReservationSeat.utils;

import com.mpek.ReservationSeat.dto.ScreeningSimpleDTO;

import java.util.Comparator;

public class ScreeningSimplyDTOComparator implements Comparator<ScreeningSimpleDTO> {
    @Override
    public int compare(ScreeningSimpleDTO o1, ScreeningSimpleDTO o2) {
        int nameComparation = o1.getMovieTitle().compareTo(o2.getMovieTitle());
        if (nameComparation == 0) {
            int dayComparation = o1.getDayOfScreening().compareTo(o2.getDayOfScreening());
            if (dayComparation == 0) {
                return o1.getTimeOfScreening().compareTo(o2.getDayOfScreening());
            } else {
                return dayComparation;
            }
        }
        return nameComparation;
    }
}
