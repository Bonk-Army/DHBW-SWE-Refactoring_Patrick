package com.p4ddy.dhbw.swe.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    private final String MOVIETITLE = "Back To The Future 2";
    private final int PRICECODE = 2;

    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie(MOVIETITLE, PRICECODE);
    }

    @Test
    void getPriceCode() {
        assertEquals(PRICECODE, movie.getPriceCode(), "Expected the price code to be " + PRICECODE);
    }

    @Test
    void setPriceCode() {
        movie.setPriceCode(0);
        assertEquals(0, movie.getPriceCode(), "Expected the price code to have been changed to 0");
    }

    @Test
    void getTitle() {
        assertEquals(MOVIETITLE, movie.getTitle(), "Expected the movie title to be " + MOVIETITLE);
    }
}
