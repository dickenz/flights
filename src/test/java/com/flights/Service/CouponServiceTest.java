package com.flights.Service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CouponServiceTest {

    @Test
    public void testApplyCoupon_ValidCouponId() {
        CouponService couponService = new CouponService();
        double ticketPrice = 100.0;
        double discountedPrice = couponService.applyCoupon(1, ticketPrice); // Assuming coupon ID 1 exists
        assertTrue(discountedPrice >= 0 && discountedPrice <= ticketPrice); // Discounted price should be within 0 and original ticket price
    }

    @Test
    public void testApplyCoupon_InvalidCouponId() {
        CouponService couponService = new CouponService();
        double ticketPrice = 100.0;
        assertThrows(IllegalArgumentException.class, () ->
                couponService.applyCoupon(10, ticketPrice) // Assuming coupon ID 10 does not exist
        );
    }
}