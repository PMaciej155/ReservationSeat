package com.mpek.ReservationSeat.controller;

import com.mpek.ReservationSeat.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
}
