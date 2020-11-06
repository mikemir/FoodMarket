package com.android.foodmarket.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final List<CartItem> ITEMS = new ArrayList<>();

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
}
