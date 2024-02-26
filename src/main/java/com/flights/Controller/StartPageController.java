package com.flights.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/flightsControl")
public class StartPageController {

    @GetMapping
    public String showStartPage() {
        return "StartPage";
    }

    @GetMapping("/checkTicketId")
    public String checkTicketPage() {
        return "checkTicketId";
    }

    @GetMapping("/performCheckIn")
    public String performCheckInPage() {
        return "redirect:/check-ins/performCheckIn";
    }

    @GetMapping("/applyCoupon")
    public String applyCouponPage() {
        return "applyCoupon";
    }
}