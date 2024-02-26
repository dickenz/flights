package com.flights.Service;

import com.flights.Entity.CheckIn;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CheckInService {
    private static final int MIN_ID = 1;
    private static final int MAX_ID = 100;

    private final Map<String, Boolean> checkInCache = new HashMap<>();

    public boolean performCheckIn(CheckIn checkIn) {
        int destinationId = checkIn.getDestinationId();
        int baggageId = checkIn.getBaggageId();

        String cacheKey = destinationId + "-" + baggageId;

        if (checkInCache.containsKey(cacheKey)) {
            return checkInCache.get(cacheKey);
        }

        boolean isValidDestinationId = isValidDestinationId(destinationId);
        boolean isValidBaggageId = isValidBaggageId(baggageId);

        boolean isSuccess = isValidDestinationId && isValidBaggageId;
        checkInCache.put(cacheKey, isSuccess);

        return isSuccess;
    }

    private boolean isValidDestinationId(int destinationId) {
        return destinationId >= MIN_ID && destinationId <= MAX_ID;
    }

    private boolean isValidBaggageId(int baggageId) {
        return baggageId >= MIN_ID && baggageId <= MAX_ID;
    }
}
