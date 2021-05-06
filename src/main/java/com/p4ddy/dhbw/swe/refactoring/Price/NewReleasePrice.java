package com.p4ddy.dhbw.swe.refactoring.Price;

import com.p4ddy.dhbw.swe.refactoring.Movie;

public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
