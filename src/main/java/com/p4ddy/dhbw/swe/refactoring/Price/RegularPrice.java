package com.p4ddy.dhbw.swe.refactoring.Price;

import com.p4ddy.dhbw.swe.refactoring.Movie;

public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
}
