package com.mpek.ReservationSeat.controller;


import com.mpek.ReservationSeat.exception.BadNameFormatException;
import com.mpek.ReservationSeat.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    IReservationService reservationService;


    @PostMapping("")
    public Map<String, Object> postReservation(@RequestParam("id") @NotNull @NotBlank Integer idOfScreening,
                                               @RequestParam("name") @NotNull @NotBlank String name,
                                               @RequestParam("surname") @NotNull @NotBlank String surname,
                                               @RequestBody @NotEmpty Map<Long, String> seats) throws Exception {

        if (isValidNameFormat(name, surname))
            throw new BadNameFormatException("Invalid name or surname format");

        return reservationService.createReservation(idOfScreening, name, surname, seats);
    }

    private boolean isValidNameFormat(String inputName, String inputSurname) {

        if (!inputName.matches("\\p{javaUpperCase}(\\p{javaLowerCase}){2,}"))
            return true;

        return !inputSurname.matches("\\p{javaUpperCase}(\\p{javaLowerCase}){2,}([ '-]\\p{javaUpperCase}(\\p{javaLowerCase}){2,})?");

    }
}
