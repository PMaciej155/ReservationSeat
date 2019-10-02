package com.mpek.ReservationSeat.service;

import com.mpek.ReservationSeat.dto.ScreeningDetailsDTO;
import com.mpek.ReservationSeat.dto.ScreeningSimpleDTO;
import com.mpek.ReservationSeat.dto.SeatDTO;
import com.mpek.ReservationSeat.model.Reservation;
import com.mpek.ReservationSeat.model.Screening;
import com.mpek.ReservationSeat.model.Seat;
import com.mpek.ReservationSeat.repository.ReservationRepository;
import com.mpek.ReservationSeat.repository.ScreeningRepository;
import com.mpek.ReservationSeat.utils.ScreeningSimplyDTOComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ScreeningServiceImpl implements IScreeningService {

    @Autowired
    ScreeningRepository screeningRepo;

    @Autowired
    ReservationRepository reservatonRepo;

    @Override
    public List<ScreeningSimpleDTO> showScreenings(Integer dayOfScreening, Integer startInterval, Integer endInterval) throws Exception {
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dayTimeFormat = new SimpleDateFormat("HHmm");
        Date date = new Date();
        Date startScreening = new Date();
        Date endScreening = new Date();
        try {
            date = dayFormat.parse(dayOfScreening.toString());
            startScreening = dayTimeFormat.parse(startInterval.toString());
            endScreening = dayTimeFormat.parse(endInterval.toString());
        } catch (Exception e) {
            throw new Exception("Bad format of date");
        }

        List<Screening> screenings = screeningRepo.findByDayOfScreening(date, startScreening, endScreening);

        return screenings
                .stream()
                .map(ScreeningSimpleDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScreeningSimpleDTO> showAllScreenings() {
        List<ScreeningSimpleDTO> allScreenings = null;

        allScreenings = screeningRepo
                .findAll()
                .stream()
                .map(ScreeningSimpleDTO::new)
                .collect(Collectors.toList());

        allScreenings.sort(new ScreeningSimplyDTOComparator());

        return allScreenings;
    }

    @Override
    public ScreeningDetailsDTO showDetailsScreening(Long idOfScreening) throws Exception {
        Screening screening = screeningRepo.findById(idOfScreening).orElseThrow(Exception::new);
        ScreeningDetailsDTO screeningDetailsDTO = new ScreeningDetailsDTO(screening);
        screeningDetailsDTO.getRoomNumber()
                .setSeats(getAvailableSeats(screening.getRoom().getSeats(), screening.getId()));

        return screeningDetailsDTO;
    }

    //I did in that because i spend enough time to fight with JPQL
    private Map<Long, SeatDTO> getAvailableSeats(Map<Long, Seat> seats, long idOfScreening) {
        Map<Long, SeatDTO> seatsOutput = new HashMap<>();
        List<Seat> reservedSeats = reservatonRepo.findByScreening(idOfScreening)
                .stream()
                .map(Reservation::getSeats)
                .map(map -> new ArrayList<>(map.keySet()))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        seatsOutput = seats
                .entrySet()
                .stream()
                .filter(entry -> !reservedSeats.contains(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new SeatDTO(entry.getValue())));

        return seatsOutput;
    }
}
