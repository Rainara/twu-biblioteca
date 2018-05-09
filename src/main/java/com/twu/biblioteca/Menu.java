package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private int movieCode, bookCode, option;
    private String userId, password;
    private Scanner sc = new Scanner(System.in);
    private BibliotecaApp bibliotecaApp;
    private Product product;
    private User userBiblioteca;
    private Login login;
    private List<Movie> movies;
    private List<Book> books;
    private List<User> users;

    Menu(){
        this.movies = Initializer.generateMovieLibrary();
        this.books = Initializer.generateBookLibrary();
        this.users = Initializer.libraryUsers();
    }

    public void menuLogged(String user){

        System.out.print("Welcome "+ user +" to the Biblioteca!\nMenu: \n1-My Details\n2-Checkout a book \n3-Checkout a movie \n4-Return a book\n5-Return a movie" +
                "\n6-Logout \n7-Quit \nEnter your Option: ");

        option = sc.nextInt();



        switch (option) {

            case 1:
                System.out.print("Your Details: ");
                try {
                    userBiblioteca.getUserDetails(userId,this.users);
                } catch (InvalidUserLoginException e) {
                    e.printStackTrace();
                }
                menuLogged(user);
                break;

            case 2:
                System.out.print("Inform the book code to checkout: ");
                bookCode = sc.nextInt();
                try {
                    System.out.println("The product "+bibliotecaApp.checkoutItem(bookCode, this.books)+" was successfully checked out!");
                } catch (NotAvailableProductException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidProductCodeException e) {
                    System.out.println(e.getMessage());
                }
                menuLogged(user);
                break;

            case 3:
                System.out.print("Inform the movie code to checkout: ");
                movieCode = sc.nextInt();
                try {
                    System.out.println("The product "+bibliotecaApp.checkoutItem(movieCode, this.movies)+" was successfully checked out!");
                } catch (NotAvailableProductException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidProductCodeException e) {
                    System.out.println(e.getMessage());
                }
                menuLogged(user);
                break;

            case 4:
                System.out.print("Inform the book code to return: ");
                bookCode = sc.nextInt();
                try {
                    bibliotecaApp.returnItem(bookCode,this.books);
                } catch (NotAvailableProductException e) {
                    e.printStackTrace();
                } catch (InvalidProductCodeException e) {
                    e.printStackTrace();
                }
                menuLogged(user);
                break;

            case 5:
                System.out.print("Inform the movie code to return: ");
                movieCode = sc.nextInt();
                try {
                    bibliotecaApp.returnItem(movieCode, this.movies);
                } catch (NotAvailableProductException e) {
                    e.printStackTrace();
                } catch (InvalidProductCodeException e) {
                    e.printStackTrace();
                }
                menuLogged(user);
                break;

            case 6:
                System.out.println("Logged out!");
                menuNotLogged();
                break;

            case 7:
                System.out.print("Your Details: ");
                try {
                    userBiblioteca.getUserDetails(userId,this.users);
                } catch (InvalidUserLoginException e) {
                    e.printStackTrace();
                }
                menuLogged(user);
                break;

            case 8:
                System.exit(0);

            default:
                System.out.println("Invalid Option!");
                menuLogged(user);
                break;

        }




    }

    public void menuNotLogged(){

        System.out.print("Welcome Guest to the Biblioteca!\nMenu: \n1-List of available books\n2-List of available movies \n3-Book details \n4-Movie details " +
                "\n5-Login \n6-Quit \nEnter your Option: ");

        option = sc.nextInt();

        switch (option){
            case 1:
                product.print(this.books);
                menuNotLogged();
                break;
            case 2:
                product.print(this.movies);
                menuNotLogged();
                break;
            case 3:
                System.out.print("Inform the book code: ");
                bookCode = sc.nextInt();
                try {
                    System.out.println(product.getProductDetails(bookCode, this.books));
                    menuNotLogged();
                } catch (InvalidProductCodeException e) {
                    System.out.println(e.getMessage());
                    menuNotLogged();
                }
                break;

            case 4:
                System.out.print("Inform the movie code: ");
                movieCode = sc.nextInt();
                try {
                    System.out.println(product.getProductDetails(movieCode, this.movies));
                    menuNotLogged();

                } catch (InvalidProductCodeException e) {
                    System.out.println(e.getMessage());
                    menuNotLogged();
                }
                break;

            case 5:
                System.out.print("Inform your username: ");
                userId = sc.next();
                System.out.print("Inform your password: ");
                password = sc.next();
                try {
                    String user = login.Login(userId, password,this.users);


                } catch (InvalidUserLoginException e) {
                    e.printStackTrace();
                    menuNotLogged();
                }
                break;

            case 6: System.exit(0);

            default: System.out.println("Invalid Option!");
                break;
        }


    }




}
