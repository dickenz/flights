package com.flights.Service;

import com.flights.Entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TicketService {
    private Map<Integer, Ticket> ticketDatabase = new HashMap<>();
    private Map<Integer, Boolean> ticketCache = new HashMap<>();

    public TicketService() {
        for (int i = 1; i <= 100; i++) {
            ticketDatabase.put(i, new Ticket(i));
        }
    }

    public boolean isTicketAvailable(int ticketId) {
        if (ticketCache.containsKey(ticketId)) {
            return ticketCache.get(ticketId);
        }

        Ticket ticket = ticketDatabase.get(ticketId);
        boolean isAvailable = ticket != null && ticket.isAvailable();
        ticketCache.put(ticketId, isAvailable);
        return isAvailable;
    }

}