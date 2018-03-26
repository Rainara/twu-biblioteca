package com.twu.biblioteca;

import java.util.List;

public class Login {

    private Menu menu;

    public String Login(String userId, String password, List<User> users) throws InvalidUserLoginException {

        for(User u:users){
            if(u.getUserId().equals(userId) && u.getPassword().equals(password)){

                System.out.println("user id: "+u.getUserId()+" is logged!");
                menu.menuLogged(u.getUserName());
            }
        }
        throw new InvalidUserLoginException("Invalid user credentials!");
    }


}
