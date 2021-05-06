package com.p4ddy.dhbw.swe.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CustomerTest {
    private final String CUSTOMERNAME = "Uschi Rosenbusch";
    private final String MOVIETITLE = "Back To The Future";
    private final String MOVIETITLE2 = "Back To The Future 2";
    private final int PRICECODE = 2;
    private final int PRICECODE2 = 0;
    private final int RENTALDAYS = 69;
    private final int RENTALDAYS2 = 420;

    private Movie movie;
    private Movie movie2;
    private Rental rental;
    private Rental rental2;
    private Customer customer;

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
        try {
            customer.addRental(rental);
        } catch (Exception e) {
            fail();
        }
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

    @Test
    void htmlStatement() {
        customer.addRental(rental);
        customer.addRental(rental2);
        String correctResult = "<h1>Rentals for <em>" + CUSTOMERNAME + "</em></h1><p>\n";
        correctResult += MOVIETITLE + ": " + 100.5 + "<br>\n";
        correctResult += MOVIETITLE2 + ": " + 629.0 + "<br>\n";
        correctResult += "</p>You owe <em>" + 729.5 + "</em><p>\n";
        correctResult += "On this rental you earned <em>" + 2 + "</em> frequent renter points</p>";

        assertEquals(correctResult, customer.htmlStatement());
    }
}
