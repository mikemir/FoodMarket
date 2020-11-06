package com.android.foodmarket.models;

public class CartItem{
    private Saucer saucer;
    private int quantify;

    public CartItem(Saucer saucer, int quantify){
        this.saucer = saucer;
        this.quantify = quantify;
    }

    public double getTotalPrice() {
        return this.saucer.getPrice() * quantify;
    }

    public Saucer getSaucer(){
        return this.saucer;
    }

    public String getId(){
        return this.saucer.getId();
    }

    public int getQuantify(){
        return this.quantify;
    }

    public void setQuantify(int quantify) {
        this.quantify = quantify;
    }
}
