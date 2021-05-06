package com.p4ddy.dhbw.swe.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalTest {
    private final String MOVIETITLE = "Back To The Future 2";
    private final int PRICECODE = 2;
    private final int RENTALDAYS = 69;

    private Movie movie;
    private Rental rental;

    @BeforeEach
    void setUp() {
        movie = new Movie(MOVIETITLE, PRICECODE);
        rental = new Rental(movie, RENTALDAYS);
    }

    @Test
    void getDaysRented() {
        assertEquals(RENTALDAYS, rental.getDaysRented(), "Expected days rented to be " + RENTALDAYS);
    }

    @Test
    void getMovie() {
        assertEquals(movie, rental.getMovie());
    }
}
