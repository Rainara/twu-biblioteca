package com.twu.biblioteca;

import java.io.IOException;
import java.util.*;

public class BibliotecaApp {


    int movieCode, bookCode, option;
    String userId, password;
    Scanner sc = new Scanner(System.in);
    private List<Movie> movies;
    private List<Book> books;
    private List<User> users;


    BibliotecaApp() {
        this.movies = Initializer.generateMovieLibrary();
        this.books = Initializer.generateBookLibrary();
        this.users = Initializer.libraryUsers();
    }

    public void menuLogged(String user){
        System.out.print("Menu: \n1-My Details\n2-Checkout a book \n3-Checkout a movie \n4-Return a book\n5-Return a movie" +
                "\n6-Logout \n7-Quit \nEnter your Option: ");

        option = sc.nextInt();

        switch (option) {

            case 1:
                System.out.print("Your Details: ");
                try {
                    getUserDetails(userId);
                } catch (InvalidUserLoginException e) {
                    e.printStackTrace();
                }
                menuLogged(user);
                break;

            case 2:
                System.out.print("Inform the book code to checkout: ");
                bookCode = sc.nextInt();
                try {
                    System.out.println("The product "+checkoutItem(bookCode, this.books)+" was successfully checked out!");
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
                    System.out.println("The product "+checkoutItem(movieCode, this.movies)+" was successfully checked out!");
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
                    returnItem(bookCode,this.books);
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
                    returnItem(movieCode, this.movies);
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
                    getUserDetails(userId);
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

        System.out.print("Menu: \n1-List of available books\n2-List of available movies \n3-Book details \n4-Movie details " +
                "\n5-Login \n6-Quit \nEnter your Option: ");

        option = sc.nextInt();

        switch (option){
            case 1:
                print(this.books);
                menuNotLogged();
                break;
            case 2:
                print(this.movies);
                menuNotLogged();
                break;
            case 3:
                System.out.print("Inform the book code: ");
                bookCode = sc.nextInt();
                try {
                    System.out.println(getItemDetails(bookCode, this.books));
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
                    System.out.println(getItemDetails(movieCode, this.movies));
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
                    String user = Login(userId, password);
                    menuLogged(user);

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

    private void print(List<? extends Product> products) {

        for (Product p : products) {
            if(p.getStatus().equals("available")){
                System.out.println(p.toString());
            }

        }

    }

    public String getItemDetails(int productCode, List<? extends Product> products) throws InvalidProductCodeException {

        for(Product p: products){
            if(p.getCode().equals(productCode)){

                return p.toString();
            }

        }

        throw new InvalidProductCodeException("Invalid Code!");
    }

    public String checkoutItem(int productCode, List<? extends Product> products) throws NotAvailableProductException, InvalidProductCodeException {

        for(Product p: products){
            if(p.getCode().equals(productCode) && p.getStatus().equals("available")){
                p.setStatus("not available");
                return p.toString();
            } else {
                throw new NotAvailableProductException("The product "+p.getName()+" is not available!");
            }
        }
        throw new InvalidProductCodeException("Invalid Code!");
    }

    public String returnItem(int productCode, List<? extends Product> products) throws NotAvailableProductException, InvalidProductCodeException {

        for(Product p: products){
            if(p.getCode().equals(productCode) && p.getStatus().equals("not available")){
                p.setStatus("available");
                return p.toString();
            }
        }
        throw new InvalidProductCodeException("Invalid Code!");
    }

    public String Login(String userId, String password) throws InvalidUserLoginException {

        boolean loginStatus = false;

        for(User u:users){
            if(u.getUserId().equals(userId) && u.getPassword().equals(password)){
                loginStatus=true;
                System.out.println("user id: "+u.getUserId()+" is logged!");
                return u.getUserId();
            }
        }
        throw new InvalidUserLoginException("Invalid user credentials!");
    }

    public String getUserDetails(String userId) throws InvalidUserLoginException {

        for (User u:users){
            if(u.getUserId().equals(userId)){
                return u.toString();
            }
        }

        throw new InvalidUserLoginException("Invalid user credentials!");
    }
}
