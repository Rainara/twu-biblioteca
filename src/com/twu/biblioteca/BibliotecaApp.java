package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    String[][] listOfMovies={{"Moana", "2017","Ron Clements and John Musker","7.6","available"},
            {"Get Out", "2017","Jordan Peele","7.7","not available"}};

    String[][] listOfBooks = {{"Harry Potter", "JK Rowling","1997","available"},
            {"The Hobbit", "Tolkien","1937","not available"}};




    public static void main(){

        System.out.println("Welcome to Biblioteca!\nMenu:\n1-List of Books\n2-Checkout Book\n3-Return Book\n3-Quit\nType your option:");
        Scanner scanIn =new Scanner(System.in);
        int option= scanIn.nextInt();
        BibliotecaApp biblioteca=new BibliotecaApp();

        biblioteca.Menu(option);

    }


    public String Menu(int option) {

        switch (option){
            case 1: callListOfItems(listOfBooks); return "List of Books";
            case 2: callListOfItems(listOfMovies);return "List of Movies";
            case 3: return "Checkout a book";
            case 4: System.exit(0);
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


    public String getBookDetails(int bookCode) {


        StringBuilder bookDetail=new StringBuilder();

        for(int i=1; i<listOfBooks[bookCode].length-1;i++)
        {
                bookDetail.append(listOfBooks[bookCode][i]).append("\n");

        }

        System.out.print(bookDetail.toString());

        return bookDetail.toString();
    }


    public String checkoutBook(int bookCode) {

        if(listOfBooks[bookCode][listOfBooks.length+1].equals("available"))
            listOfBooks[bookCode][listOfBooks.length+1]="not available";
        else
            return "That book is not available.";

        return listOfBooks[bookCode][listOfBooks.length+1];
    }


    public String returnBook(int bookCode) {

        if(listOfBooks[bookCode][listOfBooks.length+1].equals("not available"))
            listOfBooks[bookCode][listOfBooks.length+1]="available";
        else
            return "That book is not available to return.";

        return listOfBooks[bookCode][listOfBooks.length+1];


    }
}
