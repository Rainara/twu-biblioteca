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

    public void Menu() throws IOException {
        System.out.print("Menu: \n1-List of available books\n2-List of available movies \n3-Book details \n4-Movie details " +
                "\n5-Checkout a book \n6-Checkout a movie \n7-Return a book\n8-Return a movie" +
                "\n9-Login \n10-User Details\n11-Quit\nEnter your Option: ");

        option = sc.nextInt();


        switch (option) {
            case 1:
                print(this.books);
                break;
            case 2:
                print(this.movies);
                break;
            case 3:
//                TO STUDY - 20/21/22/23/24
//                this.books.stream().map(p -> p.getCode()).collect(Collectors.toList()).forEach(p -> System.out.println(p));
                System.out.print("Inform the book code: ");
                bookCode = sc.nextInt();
                try {
                    System.out.println(getItemDetails(bookCode, this.books));
                } catch (InvalidProductCodeException e) {
                    System.out.println(e.getMessage());
                    Menu();
                }
                break;

            case 4:
                System.out.print("Inform the movie code: ");
                movieCode = sc.nextInt();
                try {
                    System.out.println(getItemDetails(movieCode, this.movies));

                } catch (InvalidProductCodeException e) {
                    System.out.println(e.getMessage());
                    Menu();
                }
                break;

            case 5:
                System.out.print("Inform the book code to checkout: ");
                bookCode = sc.nextInt();
                try {
                    System.out.println("The product "+checkoutItem(bookCode, this.books)+" was successfully checked out!");
                } catch (NotAvailableProductException e) {
                    System.out.println(e.getMessage());
                    Menu();
                } catch (InvalidProductCodeException e) {
                    System.out.println(e.getMessage());
                    Menu();
                }
                break;

            case 6:
                System.out.print("Inform the movie code to checkout: ");
                movieCode = sc.nextInt();
                try {
                    System.out.println("The product "+checkoutItem(movieCode, this.movies)+" was successfully checked out!");
                } catch (NotAvailableProductException e) {
                    System.out.println(e.getMessage());
                    Menu();
                } catch (InvalidProductCodeException e) {
                    System.out.println(e.getMessage());
                    Menu();
                }
                break;

            case 7:
                System.out.print("Inform the book code to return: ");
                bookCode = sc.nextInt();
                try {
                    returnItem(bookCode,this.books);
                } catch (NotAvailableProductException e) {
                    e.printStackTrace();
                } catch (InvalidProductCodeException e) {
                    e.printStackTrace();
                }
                // returnItem(bookCode, listOfBooks);
                Menu();

            case 8:
                System.out.print("Inform the movie code to return: ");
                movieCode = sc.nextInt();
             //   returnItem(movieCode, listOfMovies);
                Menu();

            case 9:
                System.out.print("Inform your username: ");
                userId = sc.next();
                System.out.print("Inform your password: ");
                password = sc.next();
                try {
                    Login(userId, password);
                } catch (InvalidUserLoginException e) {
                    e.printStackTrace();
                }
                Menu();

            case 10:
                System.out.print("Your Details: ");
                try {
                    getUserDetails(userId);
                } catch (InvalidUserLoginException e) {
                    e.printStackTrace();
                }
                Menu();

            case 11:
                System.exit(0);
            default:
                System.out.println("Invalid Option!");
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

    public boolean Login(String userId, String password) throws InvalidUserLoginException {

        boolean loginStatus = false;

        for(User u:users){
            if(u.getUserId().equals(userId) && u.getPassword().equals(password)){
                loginStatus=true;
                System.out.println("user id: "+u.getUserId()+" is logged!");
                return loginStatus;
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
