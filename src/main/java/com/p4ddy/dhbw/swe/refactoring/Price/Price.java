package com.p4ddy.dhbw.swe.refactoring.Price;

import com.p4ddy.dhbw.swe.refactoring.Movie;

public abstract class Price {
    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);
}