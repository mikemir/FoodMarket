package com.android.foodmarket.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User("prueba@mail.com", "prueba123"));
        USERS.add(new User("ronal@mail.com", "prueba123"));
    }

    public static boolean getValidUser(String userName, String userPass){
        boolean result = false;

        for (User item:USERS) {
            if(userName.equals(item.getEmail()) && userPass.equals(item.getPassword())){
                result = true;
            }
        }

        return result;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
