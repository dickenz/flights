package com.flights.Entity;

public class Ticket {
    private int ticketId;
    private boolean isAvailable;

    public Ticket(int ticketId) {
        this.ticketId = ticketId;
        this.isAvailable = true;
    }

    public int getTicketId() {
        return ticketId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
