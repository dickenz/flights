package com.flights.Service;

import com.flights.Entity.CheckIn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckInServiceTest {

    @Test
    public void testPerformCheckIn_ValidCheckIn() {
        CheckInService checkInService = new CheckInService();
        CheckIn checkIn = new CheckIn(50, 75); // Assuming these are valid IDs
        assertTrue(checkInService.performCheckIn(checkIn));
    }

    @Test
    public void testPerformCheckIn_InvalidDestinationId() {
        CheckInService checkInService = new CheckInService();
        CheckIn checkIn = new CheckIn(150, 75); // Assuming 150 is invalid destination ID
        assertFalse(checkInService.performCheckIn(checkIn));
    }

    @Test
    public void testPerformCheckIn_InvalidBaggageId() {
        CheckInService checkInService = new CheckInService();
        CheckIn checkIn = new CheckIn(50, 175); // Assuming 175 is invalid baggage ID
        assertFalse(checkInService.performCheckIn(checkIn));
    }
}