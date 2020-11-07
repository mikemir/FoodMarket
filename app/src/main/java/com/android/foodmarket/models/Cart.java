package com.android.foodmarket.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    public static final ArrayList<CartItem> ITEMS = new ArrayList<>();

    public static void addItem(CartItem item){
        if(!ITEMS.contains(item)){
            ITEMS.add(item);
        }
    }

    public static void removeItem(int position){
        ITEMS.remove(position);
    }

    public static int getCount(){
        return ITEMS.size();
    }

    public static double getTotalAmount(){
        double total = 0;
        for (CartItem item : ITEMS) {
            total += item.getTotalPrice();
        }
        return  total;
    }

    public static void clear(){
        ITEMS.clear();
    }
}
