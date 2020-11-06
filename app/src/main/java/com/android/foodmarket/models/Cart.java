package com.android.foodmarket.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    public static final Map<String, CartItem> ITEMS = new HashMap<>();

    public static void addItem(CartItem item){
        if(ITEMS.containsKey(item.getId())){
            CartItem cartItem = ITEMS.get(item.getId());
            cartItem.setQuantify(cartItem.getQuantify() + 1);
        }
        else{
            ITEMS.put(item.getId(), item);
        }
    }

    public static void removeItem(String id){
        ITEMS.remove(id);
    }

    public static int getCount(){
        return ITEMS.size();
    }

    public static double getTotalAmount(){
        double total = 0;
        for (CartItem item : ITEMS.values()) {
            total += item.getTotalPrice();
        }
        return  total;
    }

    public static void clear(){
        ITEMS.clear();
    }
}
