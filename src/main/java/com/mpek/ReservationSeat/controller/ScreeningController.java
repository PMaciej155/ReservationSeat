package com.mpek.ReservationSeat.controller;

import com.mpek.ReservationSeat.service.ScreeningServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/screenings")
public class ScreeningController {

    @Autowired
    ScreeningServiceImpl screeningService;

    @RequestMapping("")
    public String getScreenings(@PathVariable("start") Integer startOfScreening, @PathVariable("end") Integer endOfScreening){
     return "Test";
    }

    @RequestMapping("details")
    public String getDetailsOfScreening(@PathVariable("start") Integer startOfScreening, @PathVariable("title") String movieTitle){
        return "Test2";
    }
}
