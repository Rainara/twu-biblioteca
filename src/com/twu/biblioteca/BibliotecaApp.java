package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    String[][] listOfBooks = {{"Harry Potter", "JK Rowling","1997","not available"},
            {"The Hobbit", "Tolkien","1937","available"}};

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca!\nPress the option:\n1-List of Books\n2-Checkout Book\n3-Return Book\n3-Quit");
        Scanner scanIn =new Scanner(System.in);
        int option= scanIn.nextInt();

        BibliotecaApp biblioteca=new BibliotecaApp();

        biblioteca.Menu(option);


    }


    public String Menu(int option) {
        switch (option){
            case 1: return "List of Books";
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
}
