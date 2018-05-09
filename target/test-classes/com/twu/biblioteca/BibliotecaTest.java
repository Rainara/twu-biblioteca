package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {



    @Test
    public void whenPassingAValidCodeMustReturnAnExistentProduct() throws InvalidProductCodeException {

        Product product = Mockito.mock(Product.class, Mockito.CALLS_REAL_METHODS);
        Book book = new Book(0, "Harry Potter", 1997, "available", "JK Rowling");
        assertEquals(book.toString(), product.getProductDetails(0,Initializer.generateBookLibrary()));
    }

    @Test(expected = InvalidProductCodeException.class)
    public void whenPassingAnInvalidCodeMustThrowException() throws InvalidProductCodeException, NotAvailableProductException {
        Product product = Mockito.mock(Product.class, Mockito.CALLS_REAL_METHODS);
        BibliotecaApp biblioteca = new BibliotecaApp();
        Book book = new Book(0, "Harry Potter", 1997, "available", "JK Rowling");
        assertEquals(book.toString(),product.getProductDetails(5,Initializer.generateBookLibrary()));
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
        Login login = new Login();
        assertEquals(true,login.Login("890-1234","user123",Initializer.libraryUsers()));
    }

    @Test(expected = InvalidUserLoginException.class)
    public void whenTryingWithInvalidCredentialsMustThrowException() throws InvalidUserLoginException {
        Login login = new Login();
        assertEquals(true,login.Login("890-1234","user12",Initializer.libraryUsers()));
    }

    @Test
    public void whenUserCheckTheDetailsMustShowThem() throws InvalidUserLoginException {

        User user = new User("890-1234","Joao","user@biblioteca.com","2, St Elizabeth,", "user123");
        assertEquals(user.toString(),user.getUserDetails("890-1234",Initializer.libraryUsers()));
    }



}
