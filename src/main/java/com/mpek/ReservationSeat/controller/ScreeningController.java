package com.mpek.ReservationSeat.controller;

import com.mpek.ReservationSeat.service.IScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/screenings")
public class ScreeningController {

    @Autowired
    IScreeningService screeningService;

    @GetMapping("")
    public String getScreenings(@PathVariable("start") Integer startOfScreening, @PathVariable("end") Integer endOfScreening) throws Exception {
        if (startOfScreening == null)
            throw new Exception("no screening");
        if (endOfScreening == null)
            throw new Exception("no screening");

        screeningService.showScreenings(startOfScreening, endOfScreening);

        return "Test";
    }

    @GetMapping("details")
    public String getDetailsOfScreening(@PathVariable("start") Integer startOfScreening, @PathVariable("title") String movieTitle){
        return "Test2";
    }
}
