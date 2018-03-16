package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    String[][] listOfBooks = {{"Harry Potter", "JK Rowling","1997","available"},
            {"The Hobbit", "Tolkien","1937","not available"}};

    public static void main(String args) {


        System.out.println("Welcome to Biblioteca!\nMenu:\n1-List of Books\n2-Checkout Book\n3-Return Book\n3-Quit\nType your option:");
        Scanner scanIn =new Scanner(System.in);
        int option= scanIn.nextInt();
        BibliotecaApp biblioteca=new BibliotecaApp();

        biblioteca.Menu(option);


    }


    public String Menu(int option) {



        switch (option){
            case 1: callListOfBooksApp(); return "List of Books";
            case 2: return "Checkout a book";
            case 3: System.exit(0);
            default: return "Invalid Option!";
    }
}

    public String callListOfBooksApp() {

        StringBuilder list=new StringBuilder("");


        for(int i=0;i<listOfBooks.length;i++){
            list.append(listOfBooks[i][0]).append("\n");
        }

        System.out.print(list.toString());

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
