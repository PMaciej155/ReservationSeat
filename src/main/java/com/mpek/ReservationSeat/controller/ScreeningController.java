package com.mpek.ReservationSeat.controller;

import com.mpek.ReservationSeat.dto.ScreeningDetailsDTO;
import com.mpek.ReservationSeat.dto.ScreeningSimpleDTO;
import com.mpek.ReservationSeat.service.IScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/screenings")
public class ScreeningController {

    @Autowired
    IScreeningService screeningService;

    @GetMapping("all")
    @ResponseBody
    public List<ScreeningSimpleDTO> getAllScreenings() {
        return screeningService.showAllScreenings();
    }

    @GetMapping("")

    public List<ScreeningSimpleDTO> getScreenings(@RequestParam("date") Integer dayOfScreening, @RequestParam("start") Integer startOfScreening, @RequestParam("end") Integer endOfScreening) throws Exception {

        return screeningService.showScreenings(dayOfScreening, startOfScreening, endOfScreening);
    }

    @GetMapping("details")
    public ScreeningDetailsDTO getDetailsOfScreening(@RequestParam("id") long idOfScreening) {
        ScreeningDetailsDTO detailedScreening = new ScreeningDetailsDTO();
        try {
            detailedScreening = screeningService.showDetailsScreening(idOfScreening);
        } catch (Exception e) {

        }
        return detailedScreening;
    }
}
