package com.flights.Controller;

import com.flights.Service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coupons")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/applyCoupon/{couponId}")
    public ResponseEntity<Double> applyCoupon(@PathVariable int couponId, @RequestParam double ticketPrice) {
        try {
            double discountedPrice = couponService.applyCoupon(couponId, ticketPrice);
            return ResponseEntity.ok(discountedPrice);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}