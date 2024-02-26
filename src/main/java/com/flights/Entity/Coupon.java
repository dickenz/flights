package com.flights.Entity;

public class Coupon {
    private int couponId;
    private int discount;

    public Coupon (int couponId, int discount){
        this.couponId = couponId;
        this.discount = discount;
    }

    public int getCouponId() {
        return couponId;
    }

    public int getDiscount() {
        return discount;
    }
}
