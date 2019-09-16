package com.mpek.ReservationSeat.controller;

import com.mpek.ReservationSeat.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/API/reservation")
public class ReservationController {

    @Autowired
    IReservationService reservationService;


    @PostMapping("/{id}")
    public String postReservation(@RequestBody Map<Integer, String> seats) {
        return "";
    }


}
