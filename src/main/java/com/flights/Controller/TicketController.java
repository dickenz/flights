package com.flights.Controller;

import com.flights.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/checkTicketId/{ticketId}")
    public ResponseEntity<Boolean> checkTicketAvailability(@PathVariable int ticketId) {
        boolean isAvailable = ticketService.isTicketAvailable(ticketId);
        return ResponseEntity.ok(isAvailable);
    }

}


