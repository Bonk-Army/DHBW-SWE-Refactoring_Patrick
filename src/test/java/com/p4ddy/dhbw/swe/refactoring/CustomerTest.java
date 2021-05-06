package com.p4ddy.dhbw.swe.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    final String CUSTOMERNAME = "Uschi Rosenbusch";
    final String MOVIETITLE = "Back To The Future";
    final String MOVIETITLE2 = "Back To The Future 2";
    final int PRICECODE = 2;
    final int PRICECODE2 = 0;
    final int RENTALDAYS = 69;
    final int RENTALDAYS2 = 420;

    Movie movie;
    Movie movie2;
    Rental rental;
    Rental rental2;
    Customer customer;

    @BeforeEach
    void setUp() {
        movie = new Movie(MOVIETITLE, PRICECODE);
        movie2 = new Movie(MOVIETITLE2, PRICECODE2);
        rental = new Rental(movie, RENTALDAYS);
        rental2 = new Rental(movie2, RENTALDAYS2);
        customer = new Customer(CUSTOMERNAME);
    }

    @Test
    void addRental() {
        customer.addRental(rental);
    }

    @Test
    void getName() {
        assertEquals(CUSTOMERNAME, customer.getName(), "Expected the customer name to be " + CUSTOMERNAME);
    }

    @Test
    void statement() {
        customer.addRental(rental);
        customer.addRental(rental2);
        String correctResult = "Rental Record for " + CUSTOMERNAME + "\n";
        correctResult += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        correctResult += "\t" + MOVIETITLE + "\t" + "\t" + RENTALDAYS + "\t" + 100.5 + "\n";
        correctResult += "\t" + MOVIETITLE2 + "\t" + "\t" + RENTALDAYS2 + "\t" + 629.0 + "\n";
        correctResult += "Amount owed is " + 729.5 + "\n";
        correctResult += "You earned " + 2 + " frequent renter points";

        assertEquals(correctResult, customer.statement());
    }
}
