package com.twu.biblioteca;


import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    /*
     @Test
    public void testMenuOptions() {

        BibliotecaApp biblioteca=new BibliotecaApp();

        assertEquals("List of Books",biblioteca.Menu(1));
        assertEquals("List of Movies", biblioteca.Menu(2));


    } */



    /*@Test
    public void testMenuList(){

        BibliotecaApp biblioteca=new BibliotecaApp();

        assertEquals("Harry Potter\n",biblioteca.callListOfItems(biblioteca.listOfBooks));

        assertEquals("Moana\n",biblioteca.callListOfItems(biblioteca.listOfMovies));


    }*/

    @Test
    public void whenPassingAValidCodeMustReturnAnExistentProduct() throws InvalidProductCodeException {
        BibliotecaApp biblioteca = new BibliotecaApp();
        Book book = new Book(0, "Harry Potter", 1997, "available", "JK Rowling");
        assertEquals(book.toString(), biblioteca.getItemDetails(0, Initializer.generateBookLibrary()));
    }

    @Test(expected = InvalidProductCodeException.class)
    public void whenPassingAnInvalidCodeMustThrowException() throws InvalidProductCodeException, NotAvailableProductException {
        BibliotecaApp biblioteca = new BibliotecaApp();
        Book book = new Book(0, "Harry Potter", 1997, "available", "JK Rowling");
        assertEquals(book.toString(),biblioteca.getItemDetails(5,Initializer.generateBookLibrary()));
        assertEquals(book.toString(),biblioteca.checkoutItem(6,Initializer.generateBookLibrary()));
    }

    @Test
    public void whenPassingAnAvailableBookMustAcceptCheckout() throws InvalidProductCodeException, NotAvailableProductException {
        BibliotecaApp biblioteca = new BibliotecaApp();
        Book book = new Book(0, "Harry Potter", 1997, "not available", "JK Rowling");
        assertEquals(book.toString(),biblioteca.checkoutItem(0,Initializer.generateBookLibrary()));
    }

    @Test(expected = NotAvailableProductException.class)
    public void whenPassingANotAvailableBookMustThrowException() throws InvalidProductCodeException, NotAvailableProductException {
        BibliotecaApp biblioteca = new BibliotecaApp();
        Book book=new Book(1, "The Hobbit", 1937, "not available", "Tolkien");
        assertEquals(book.toString(),biblioteca.checkoutItem(1,Initializer.generateBookLibrary()));
    }

    @Test
    public void whenPassingANotAvailableProductMustAcceptReturn() throws InvalidProductCodeException, NotAvailableProductException {
        BibliotecaApp biblioteca = new BibliotecaApp();
        Book book=new Book(1, "The Hobbit", 1937, "available", "Tolkien");
        assertEquals(book.toString(),biblioteca.returnItem(1,Initializer.generateBookLibrary()));
    }

    @Test
    public void whenTryingToLoginMustAllowIt() throws InvalidUserLoginException {

        BibliotecaApp biblioteca = new BibliotecaApp();
        assertEquals(true,biblioteca.Login("890-1234","user123"));
    }

    @Test(expected = InvalidUserLoginException.class)
    public void whenTryingWithInvalidCredentialsMustThrowException() throws InvalidUserLoginException {

        BibliotecaApp biblioteca = new BibliotecaApp();
        assertEquals(true,biblioteca.Login("890-1234","user12"));

    }






    @Test
    @Ignore
    public void whenCheckoutAValidItem(){

        BibliotecaApp biblioteca= new BibliotecaApp();

       // assertEquals("not available",biblioteca.checkoutItem(0,biblioteca.listOfBooks));
        //assertEquals("not available",biblioteca.checkoutItem(0,biblioteca.listOfMovies));

    }

    @Test
    @Ignore
    public void testReturnItem(){

        BibliotecaApp biblioteca = new BibliotecaApp();

      //  assertEquals("available",biblioteca.returnItem(1,biblioteca.listOfBooks));
       // assertEquals("available",biblioteca.returnItem(1,biblioteca.listOfMovies));

    }

    @Test
    @Ignore
    public void testListAvailableBooks(){

        BibliotecaApp biblioteca=new BibliotecaApp();

        //assertEquals("Harry Potter\n",biblioteca.callListOfItems(biblioteca.listOfBooks));

    }



    @Test
    public void testUserInformation(){

        BibliotecaApp biblioteca= new BibliotecaApp();

        assertEquals("",biblioteca.getUserDetails("123-4567"));

    }










}
