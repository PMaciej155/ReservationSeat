package com.mpek.ReservationSeat.service;


import com.mpek.ReservationSeat.exception.BookingTimeoutException;
import com.mpek.ReservationSeat.exception.FreeGapSeatException;
import com.mpek.ReservationSeat.model.Reservation;
import com.mpek.ReservationSeat.model.ReservationType;
import com.mpek.ReservationSeat.model.Screening;
import com.mpek.ReservationSeat.model.Seat;
import com.mpek.ReservationSeat.repository.ReservationRepository;
import com.mpek.ReservationSeat.repository.ScreeningRepository;
import com.mpek.ReservationSeat.utils.SeatComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements IReservationService {
    @Autowired
    private
    ReservationRepository reservationRepo;

    @Autowired
    private
    ScreeningRepository screeningRepository;

    @Override
    public Map<String, Object> createReservation(Integer id,
                                                 String name,
                                                 String surname,
                                                 Map<Long, String> seats) throws FreeGapSeatException {


        Screening screening = screeningRepository.findById(id);
        Reservation reservation = new Reservation();

        reservation.setSeats(seats
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry ->
                                screening.getRoom().getSeats().get(entry.getKey())
                        , entry -> ReservationType.valueOf(entry.getValue()))));
        if (isSpaceLeft(reservation.getSeats()))
            throw new FreeGapSeatException("Found gap in you reservation");

        reservation.setScreening(screening);


        reservation.setName(name);
        reservation.setSurname(surname);

        Map<String, Object> outpurValue = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+1"));
        Date date = new Date();

        try {
            reservation.setCreationDay(formatter.parse(formatter.format(date)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (isTimeout(reservation.getCreationDay(), screening.getDayOfScreening(), screening.getTimeOfScreening()) != 1)
            throw new BookingTimeoutException("Too late for reservation");


        reservation.setExprationDay(Date
                .from(reservation
                        .getCreationDay()
                        .toInstant()
                        .plus(Duration
                                .ofMinutes(15))));


        reservation.setCostOfReservation(reservation
                .getSeats()
                .values()
                .stream()
                .mapToDouble(ReservationType::getCost).sum());


        reservationRepo.save(reservation);

        outpurValue.put("expirationDay", Date.from(reservation.getExprationDay().toInstant().plus(Duration.ofHours(2))));
        outpurValue.put("cost", reservation.getCostOfReservation());
        return outpurValue;
    }


    private boolean isSpaceLeft(Map<Seat, ReservationType> inputSeats) {

        Map<Integer, List<Seat>> seatsByRow = inputSeats.keySet()
                .stream()
                .sorted(new SeatComparator())
                .collect(Collectors.groupingBy(Seat::getRowOfSeat));

        return seatsByRow.values()
                .stream()
                .map(list -> (list.get(0).getNumberOfSeat() + list.size() == list.get(list.size() - 1).getNumberOfSeat() + 1))
                .anyMatch(x -> x.equals(false));
    }

    private int isTimeout(Date dateOfReservation, Date dayOfScreeing, Date timeOfScreening) {
        LocalDate datePart = LocalDate.parse(dayOfScreeing.toString());
        LocalTime timePart = LocalTime.parse(timeOfScreening.toString());
        LocalDateTime datetimeOfReservation = LocalDateTime.parse(dateOfReservation.toString());
        LocalDateTime datetimeOfScreening = LocalDateTime.of(datePart, timePart);

        return datetimeOfScreening.plus(Duration.ofMinutes(15)).compareTo(datetimeOfReservation);
    }



}
