package com.twu.biblioteca;


import org.junit.Rule;
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

    @Test
    public void testGetBookDetails(){

        BibliotecaApp biblioteca=new BibliotecaApp();

        assertEquals("JK Rowling\n" +
                "1997\n",biblioteca.getBookDetails(0));



    }



    @Test
    public void testCheckoutBook(){

        BibliotecaApp biblioteca= new BibliotecaApp();

        assertEquals("not available",biblioteca.checkoutBook(0));

    }

    @Test
    public void testReturnBook(){

        BibliotecaApp biblioteca = new BibliotecaApp();

        assertEquals("available",biblioteca.returnBook(1));

    }

    @Test
    public void testListAvailableBooks(){

        BibliotecaApp biblioteca=new BibliotecaApp();

        assertEquals("Harry Potter\n",biblioteca.callListOfBooksApp());

    }







}
