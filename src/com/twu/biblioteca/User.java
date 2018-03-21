package com.twu.biblioteca;

public class User {

    //name, email address and phone number
    private String userId;
    private String email;
    private String address;
    private String password;

    public User(String userId, String email, String address, String password) {
        this.userId = userId;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
