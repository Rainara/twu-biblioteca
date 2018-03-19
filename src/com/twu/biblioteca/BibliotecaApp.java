package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    String[][] listOfMovies={{"Moana", "2017","Ron Clements and John Musker","7.6","available"},
            {"Get Out", "201","Jordan Peele","7.7","not available"}};

    String[][] listOfBooks = {{"Harry Potter", "JK Rowling","1997","available"},
            {"The Hobbit", "Tolkien","1937","not available"}};

    //name, email address and phone number
    String[][] listOfUsers = {{"Admin","123-4567","admin123","Joao","joao@admin.com","3333-3333","not logged"},
            {"User","890-1234","user123","Maria","maria@user.com","4444-4444","logged"}};

    int movieCode,bookCode;



    public String Menu() {

        System.out.print("Menu: \n1-List of available books\n2-List of available movies \n3-Book details \n4-Movie details " +
                "\n5-Checkout a book \n6-Checkout a movie \n7-Return a book\n8-Return a movie" +
                "\n9-Quit \nEnter your Option: ");

        Scanner sc  = new Scanner(System.in);

        int option = sc.nextInt();

        switch (option){
            case 1: callListOfItems(listOfBooks); Menu();

            case 2: callListOfItems(listOfMovies);Menu();

            case 3: System.out.print("Inform the book code: ");
                Scanner s  = new Scanner(System.in);
                bookCode = s.nextInt();
                getItemDetails(bookCode,listOfBooks);
                Menu();

            case 4: System.out.print("Inform the movie code: ");
                Scanner s2  = new Scanner(System.in);
                movieCode = s2.nextInt();
                getItemDetails(movieCode,listOfMovies);
                Menu();

            case 5: System.out.print("Inform the book code to checkout: ");
                Scanner s3  = new Scanner(System.in);
                bookCode = s3.nextInt();
                checkoutItem(bookCode,listOfBooks);
                Menu();

            case 6: System.out.print("Inform the movie code to checkout: ");
                Scanner s4  = new Scanner(System.in);
                movieCode = s4.nextInt();
                checkoutItem(movieCode,listOfMovies);
                return "Checkout a movie";

            case 7: System.out.print("Inform the book code to return: ");
                Scanner s5  = new Scanner(System.in);
                bookCode = s5.nextInt();
                returnItem(bookCode,listOfBooks);
                Menu();

            case 8: System.out.print("Inform the movie code to return: ");
                Scanner s6  = new Scanner(System.in);
                movieCode = s6.nextInt();
                returnItem(movieCode,listOfMovies);
                Menu();

            case 9: System.exit(0);
            default: return "Invalid Option!";
    }
}

    public String callListOfItems(String[][] listOfItems) {

        StringBuilder list=new StringBuilder("");


        for(int i=0;i<listOfItems.length;i++){
            if(listOfItems[i][listOfItems[i].length - 1].equals("available"))
                list.append(listOfItems[i][0]).append("\n");

        }
        System.out.print(list);

        return list.toString();
    }


    public String getItemDetails(int bookCode, String[][] listOfItems) {


        StringBuilder bookDetail=new StringBuilder();

        for(int i = 1; i< listOfItems[bookCode].length-1; i++)
        {
                bookDetail.append(listOfItems[bookCode][i]).append("\n");

        }

        System.out.print(bookDetail.toString());

        return bookDetail.toString();
    }


    public String checkoutItem(int itemCode, String[][] listOfItems) {

        if(listOfItems[itemCode][listOfItems[itemCode].length - 1].equals("available"))
            listOfItems[itemCode][listOfItems[itemCode].length - 1]="not available";
        else
            return "That book is not available.";

        return listOfItems[itemCode][listOfItems[itemCode].length - 1];
    }


    public String returnItem(int itemCode, String[][] listOfItems) {

        if(listOfItems[itemCode][listOfItems[itemCode].length - 1].equals("not available"))
            listOfItems[itemCode][listOfItems[itemCode].length - 1]="available";
        else
            return "That book is not available to return.";

        return listOfItems[itemCode][listOfItems[itemCode].length - 1];


    }

    public boolean Login(String userName, String password) {

        boolean loogged=false;

        for(int i=0;i<listOfUsers.length;i++){
            for(int j=0;j<listOfUsers[i].length;j++){
                if(userName.equals(listOfUsers[i][j]) && password.equals(listOfUsers[i][j+1]))
                    loogged=true;
            }
        }

        return loogged;
    }

    public String getUserDetails(String userName) {

        return "";
    }
}
