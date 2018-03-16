package com.twu.biblioteca;


import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void testMenuOptions() {

        BibliotecaApp biblioteca=new BibliotecaApp();

        assertEquals("List of Books",biblioteca.Menu(1));
        assertEquals("List of Movies", biblioteca.Menu(2));


    }


    @Test
    public void testMenuList(){

        BibliotecaApp biblioteca=new BibliotecaApp();

        assertEquals("Harry Potter\n",biblioteca.callListOfItems(biblioteca.listOfBooks));

        assertEquals("Moana\n",biblioteca.callListOfItems(biblioteca.listOfMovies));


    }


    @Test
    public void testGetItemDetails(){

        BibliotecaApp biblioteca=new BibliotecaApp();

        assertEquals("JK Rowling\n" +
                "1997\n",biblioteca.getItemDetails(0,biblioteca.listOfBooks));

        assertEquals("2017\n" +
                "Ron Clements and John Musker\n" +
                "7.6\n",biblioteca.getItemDetails(0,biblioteca.listOfMovies));


    }


    @Test
    public void testCheckoutItem(){

        BibliotecaApp biblioteca= new BibliotecaApp();

        assertEquals("not available",biblioteca.checkoutItem(0,biblioteca.listOfBooks));
        assertEquals("not available",biblioteca.checkoutItem(0,biblioteca.listOfMovies));

    }

    @Test
    public void testReturnItem(){

        BibliotecaApp biblioteca = new BibliotecaApp();

        assertEquals("available",biblioteca.returnItem(1,biblioteca.listOfBooks));
        assertEquals("available",biblioteca.returnItem(1,biblioteca.listOfMovies));

    }

    @Test
    public void testListAvailableBooks(){

        BibliotecaApp biblioteca=new BibliotecaApp();

        assertEquals("Harry Potter\n",biblioteca.callListOfItems(biblioteca.listOfBooks));

    }










}
