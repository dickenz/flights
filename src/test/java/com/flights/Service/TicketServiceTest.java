package com.flights.Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketServiceTest {

    @Test
    public void testIsTicketAvailable_ValidTicketId() {
        TicketService ticketService = new TicketService();
        assertTrue(ticketService.isTicketAvailable(1));
    }

    @Test
    public void testIsTicketAvailable_InvalidTicketId() {
        TicketService ticketService = new TicketService();
        assertFalse(ticketService.isTicketAvailable(101));
    }
}
