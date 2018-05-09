package com.twu.biblioteca;

import java.util.List;

public class User {

    //name, email address and phone number
    private String userId;
    private String userName;
    private String email;
    private String address;
    private String password;

    public User(String userId, String userName, String email, String address, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getUserName() {
        return userName;
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

    public String getUserDetails(String userId,List<User> users) throws InvalidUserLoginException {

        for (User u:users){
            if(u.getUserId().equals(userId)){
                return u.toString();
            }
        }

        throw new InvalidUserLoginException("Invalid user credentials!");
    }
}
