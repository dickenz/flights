package com.flights.Service;

import com.flights.Entity.Coupon;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class CouponService {
    private Map<Integer, Coupon> couponDatabase = new HashMap<>();
    private Random random = new Random();
    private Map<Integer, Double> couponCache = new HashMap<>();

    public CouponService() {
        couponDatabase.put(1, new Coupon(1, generateRandomDiscount()));
        couponDatabase.put(2, new Coupon(2, generateRandomDiscount()));
        couponDatabase.put(3, new Coupon(3, generateRandomDiscount()));
        couponDatabase.put(4, new Coupon(4, generateRandomDiscount()));
        couponDatabase.put(5, new Coupon(5, generateRandomDiscount()));
    }

    public double applyCoupon(int couponId, double ticketPrice) {
        if (couponCache.containsKey(couponId)) {
            double discount = couponCache.get(couponId);
            double discountedPrice = ticketPrice * (1 - discount / 100);
            return discountedPrice;
        }

        Coupon coupon = couponDatabase.get(couponId);
        if (coupon != null) {
            double discount = coupon.getDiscount();
            couponCache.put(couponId, discount);

            double discountedPrice = ticketPrice * (1 - discount / 100);
            return discountedPrice;
        } else {
            throw new IllegalArgumentException("Invalid coupon ID");
        }
    }

    private int generateRandomDiscount() {
        int[] possibleDiscounts = {10, 50, 60};
        int randomIndex = random.nextInt(possibleDiscounts.length);
        return possibleDiscounts[randomIndex];
    }
}
