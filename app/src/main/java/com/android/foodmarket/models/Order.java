package com.android.foodmarket.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private double totalAmount;
    private int quantity;
    private Date creationDate;
    private List<Saucer> items;

    public Order(){

    }

    public Order(int id, double totalAmount, int quantity, Date creationDate){
        this.id = id;
        this.totalAmount = totalAmount;
        this.quantity = quantity;
        this.creationDate = creationDate;
    }

    public static final List<Order> ORDERS = new ArrayList<>();

    static {
        ORDERS.add(new Order(1, 75.99f, 5, new Date(2020, 8, 12, 12, 10)));
        ORDERS.add(new Order(2, 35.49f, 3, new Date(2020, 8, 23, 6, 10)));
        ORDERS.add(new Order(3, 16f, 2, new Date(2020, 9, 12, 2, 10)));
        ORDERS.add(new Order(4, 8.99f, 1, new Date(2020, 10, 5, 12, 10)));
        ORDERS.add(new Order(5, 89.75f, 6, new Date(2020, 10, 10, 8, 30)));
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getId() {
        return id;
    }

    public List<Saucer> getItems() {
        return items;
    }
}
