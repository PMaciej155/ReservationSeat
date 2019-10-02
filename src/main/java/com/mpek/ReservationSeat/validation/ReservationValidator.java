package com.mpek.ReservationSeat.validation;

import com.mpek.ReservationSeat.model.Reservation;
import com.mpek.ReservationSeat.model.ReservationType;
import com.mpek.ReservationSeat.model.Seat;
import com.mpek.ReservationSeat.utils.SeatComparator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReservationValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Reservation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Reservation reservation = (Reservation) o;
        if (checkInputString(reservation.getName())) {
            errors.rejectValue("name", "name.empty");
        }

        if (checkInputString(reservation.getSurname())) {
            errors.rejectValue("surname", "surname.empty");
        }

        if (nameIsValid(reservation.getName())) {
            errors.rejectValue("name", "name.format");
        }

        if (surnameIsValid(reservation.getSurname())) {
            errors.rejectValue("surname", "surname.format");
        }

        if (checkInputSeats(reservation.getSeats())) {
            errors.rejectValue("seats", "seats.empty");
        }

        if (isSpaceLeft(reservation.getSeats())) {
            errors.rejectValue("seats", "seats.freeseat");
        }

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

    private boolean checkInputSeats(Map<Seat, ReservationType> inputSeats) {
        return inputSeats == null || inputSeats.isEmpty();
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }

    private boolean nameIsValid(String input) {
        return input.length() < 3 || Character.isLowerCase(input.charAt(0));
    }

    private boolean surnameIsValid(String input) {
        if (!input.contains("-"))
            return input.length() < 3 || Character.isLowerCase(input.charAt(0));
        else {
            String[] splitInput = input.split("-");
            if (splitInput.length == 2) {
                return splitInput[0].length() < 3 || Character.isLowerCase(splitInput[0].charAt(0)) ||
                        splitInput[1].length() < 3 || Character.isLowerCase(splitInput[1].charAt(0));
            } else
                return false;
        }
    }
}
