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



    public String Menu(int option) {

        switch (option){
            case 1: callListOfItems(listOfBooks); return "List of Books";
            case 2: callListOfItems(listOfMovies);return "List of Movies";
            case 3: return "Checkout a book";
            case 4: return "Checkout a movie";
            case 5: return "Return a book";
            case 6: return "Return a movie";
            case 7: System.exit(0);
            default: return "Invalid Option!";
    }
}

    public String callListOfItems(String[][] listOfItems) {

        StringBuilder list=new StringBuilder("");


        for(int i=0;i<listOfItems.length;i++){
            if(listOfItems[i][listOfItems[i].length - 1].equals("available"))
                list.append(listOfItems[i][0]).append("\n");

        }

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
}
