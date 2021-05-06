package com.p4ddy.dhbw.swe.refactoring;

import java.lang.*;
import java.util.*;

class Customer {
    private String customerName;
    private Vector rentals = new Vector();

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return customerName;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentalsEnum = rentals.elements();
        String resultStatement = "Rental Record for " + this.getName() + "\n";
        resultStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentalsEnum.hasMoreElements()) {
            Rental currentRental = (Rental) rentalsEnum.nextElement();
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((currentRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && currentRental.getDaysRented() > 1)
                frequentRenterPoints++;
            //show figures for this rental
            resultStatement += "\t" + currentRental.getMovie().getTitle() + "\t" + "\t" + currentRental.getDaysRented() + "\t" + String.valueOf(currentRental.getCharge()) + "\n";
            totalAmount += currentRental.getCharge();
        }
        //add footer lines
        resultStatement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        resultStatement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return resultStatement;
    }
}
