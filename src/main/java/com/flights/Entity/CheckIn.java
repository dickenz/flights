package com.flights.Entity;

public class CheckIn {
    private int destinationId;
    private int baggageId;

    public CheckIn() {
    }

    public CheckIn (int destinationId, int baggageId) {
        this.destinationId = destinationId;
        this.baggageId = baggageId;

    }


    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public int getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(int baggageId) {
        this.baggageId = baggageId;
    }
}