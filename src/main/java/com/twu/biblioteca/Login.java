package com.twu.biblioteca;

import java.util.List;

public class Login {

    public Login() {

    }

    public boolean Login(String userId, String password, List<User> users) throws InvalidUserLoginException {

        for(User u:users){
            if(u.getUserId().equals(userId) && u.getPassword().equals(password)){

                System.out.println("user id: "+u.getUserId()+" is logged!Hello "+ u.getUserName()+" Welcome to the Biblioteca!");
                return true;

            }
        }
        throw new InvalidUserLoginException("Invalid user credentials!");
    }




}
