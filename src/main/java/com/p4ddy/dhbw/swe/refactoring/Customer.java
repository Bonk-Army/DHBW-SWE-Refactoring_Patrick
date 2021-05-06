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
            double currentAmount = 0;
            Rental currentRental = (Rental) rentalsEnum.nextElement();
            //determine amounts for each line
            currentAmount = amountFor(currentRental);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((currentRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && currentRental.getDaysRented() > 1)
                frequentRenterPoints++;
            //show figures for this rental
            resultStatement += "\t" + currentRental.getMovie().getTitle() + "\t" + "\t" + currentRental.getDaysRented() + "\t" + String.valueOf(currentAmount) + "\n";
            totalAmount += currentAmount;
        }
        //add footer lines
        resultStatement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        resultStatement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return resultStatement;
    }

    private double amountFor(Rental currentRental) {
        double result = 0;
        switch (currentRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (currentRental.getDaysRented() > 2)
                    result += (currentRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += currentRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (currentRental.getDaysRented() > 3)
                    result += (currentRental.getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }

}
