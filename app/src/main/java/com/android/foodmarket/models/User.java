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
        USERS.add(new User("", ""));
        USERS.add(new User("admin@mail.com", "prueba123"));
        USERS.add(new User("ronald@mail.com", "prueba123"));
    }

    public static boolean exist(String email){
        boolean result = false;

        for (User item:USERS) {
            if(email.equals(item.getEmail())){
                result = true;
            }
        }

        return result;
    }

    public static boolean isValidUser(String userName, String userPass){
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
