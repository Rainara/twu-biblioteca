package com.twu.biblioteca;

public class Book extends Product {

    private String writer;


    public Book(Integer code, String name, Integer year, String status, String writer) {
        super(code, name, year, status);

        this.writer = writer;
    }

    @Override
    public String toString() {
        return super.toString().concat(", writer= ").concat(this.writer).concat("}");
    }
}
