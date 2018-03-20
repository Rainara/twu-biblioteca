package com.twu.biblioteca;

public class Movie extends Product {

    private String director;
    private double rate;


    public Movie(Integer code, String name, Integer year, String status, String director, double rate) {
        super(code, name, year, status);
        this.director = director;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "director='" + director + '\'' +
                ", rate=" + rate +
                '}';
    }
}
