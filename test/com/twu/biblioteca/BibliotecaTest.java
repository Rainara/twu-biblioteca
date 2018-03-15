package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void testMenuOptions() {

        BibliotecaApp biblioteca=new BibliotecaApp();

        assertEquals("List of Books",biblioteca.Menu(1));


    }


    @Test
    public void testMenuListBooks(){

        BibliotecaApp biblioteca=new BibliotecaApp();

        assertEquals("Harry Potter\n" +
                        "The Hobbit\n"
                ,biblioteca.callListOfBooksApp());


    }
}
