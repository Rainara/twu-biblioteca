package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Initializer {

    public static List<Movie> generateMovieLibrary(){

        Movie moana = new Movie(2, "Moana", 2017, "available", "Ron Clements and John Musker", 7.6);
        Movie getOut = new Movie(3, "Get Out", 2017, "available", "Jordan Peele", 7.7);

        return Arrays.asList(moana, getOut);

    };

    public static List<Book> generateBookLibrary(){
        Book harryPotter = new Book(0, "Harry Potter", 1997, "available", "JK Rowling");
        Book theHobbit = new Book(1, "The Hobbit", 1937, "not available", "Tolkien");

        return Arrays.asList(harryPotter, theHobbit);

    };

    public static List<User> libraryUsers(){

        User admin = new User("123-4567", "Maria","adm@biblioteca.com", "127, Av Jhon,Miami","admin123");
        User user = new User("890-1234","Joao","user@biblioteca.com","2, St Elizabeth,", "user123");

        return Arrays.asList(admin,user);

    };



}
