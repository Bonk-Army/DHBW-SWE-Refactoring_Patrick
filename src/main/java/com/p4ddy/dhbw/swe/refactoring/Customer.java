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
        Enumeration rentalsEnum = rentals.elements();
        String resultStatement = "Rental Record for " + this.getName() + "\n";
        resultStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentalsEnum.hasMoreElements()) {
            Rental currentRental = (Rental) rentalsEnum.nextElement();
            //show figures for this rental
            resultStatement += "\t" + currentRental.getMovie().getTitle() + "\t" + "\t" + currentRental.getDaysRented() + "\t" + String.valueOf(currentRental.getCharge()) + "\n";
        }
        //add footer lines
        resultStatement += "Amount owed is " + getTotalCharge() + "\n";
        resultStatement += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return resultStatement;
    }

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = "<h1>Rentals for <em>" + getName() + "</em></h1><p>\n";
        while (rentals.hasMoreElements()) {
            Rental currentRental = (Rental) rentals.nextElement();
            //show figures for each rental
            result += currentRental.getMovie().getTitle() + ": " +
                    String.valueOf(currentRental.getCharge()) + "<br>\n";
        }
        //add footer lines
        result += "</p>You owe <em>" + String.valueOf(getTotalCharge()) + "</em><p>\n";
        result += "On this rental you earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em> frequent renter points</p>";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental currentRental = (Rental) rentals.nextElement();
            result += currentRental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental currentRental = (Rental) rentals.nextElement();
            result += currentRental.getFrequentRenterPoints();
        }
        return result;
    }
}
