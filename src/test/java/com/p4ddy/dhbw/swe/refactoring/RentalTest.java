package com.p4ddy.dhbw.swe.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentalTest {
    final String MOVIETITLE = "Back To The Future 2";
    final int PRICECODE = 2;
    final int RENTALDAYS = 69;

    Movie movie;
    Rental rental;

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
