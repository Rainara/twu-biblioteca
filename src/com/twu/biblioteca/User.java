package com.twu.biblioteca;

public class User {

    //name, email address and phone number
    private String userName;
    private String email;
    private String address;
    private String password;

    public User(String userName, String email, String address, String password) {
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
