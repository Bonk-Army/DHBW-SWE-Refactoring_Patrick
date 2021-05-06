package com.p4ddy.dhbw.swe.refactoring;

class Rental {
    Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        // one bonus point for a two day new release rental
        if ((movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
