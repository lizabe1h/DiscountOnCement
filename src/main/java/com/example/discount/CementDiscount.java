package com.example.discount;


public class CementDiscount implements IDiscount {
    @Override
    public double calculateDiscount(int position) {
        return Math.max(0,50-5*(position-1))/100.0;
    }

}
