package com.flights.Controller;

import com.flights.Entity.CheckIn;
import com.flights.Service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/check-ins")
public class CheckInController {
    @Autowired
    private CheckInService checkInService;


    @PostMapping("/performCheckIn")
    public String performCheckIn(@ModelAttribute CheckIn checkIn, Model model) {
        boolean isCheckInSuccessful = checkInService.performCheckIn(checkIn);
        model.addAttribute("isCheckInSuccessful", isCheckInSuccessful);
        return "checkInResult";
    }

    @GetMapping("/performCheckIn")
    public String showCheckInForm(Model model) {
        model.addAttribute("checkIn", new CheckIn());
        return "performCheckIn";
    }

    @GetMapping("/checkInResult")
    public String showCheckInResult(Model model) {
        return "checkInResult";
    }
}