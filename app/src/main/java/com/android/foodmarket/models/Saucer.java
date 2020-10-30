package com.android.foodmarket.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import  com.android.foodmarket.R;

public class Saucer {
    private String id;
    private String name;
    private String description;
    private double price;
    private int image;

    public Saucer(double price, String name, int image){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public static final List<Saucer> BEBIDAS = new ArrayList<>();
    public static final List<Saucer> POSTRES = new ArrayList<>();
    public static final List<Saucer> PLATILLOS = new ArrayList<>();

    static {
        PLATILLOS.add(new Saucer(5, "Camarones Tismados", R.drawable.camarones));
        PLATILLOS.add(new Saucer(3.2f, "Rosca Herbárea", R.drawable.rosca));
        PLATILLOS.add(new Saucer(12f, "Sushi Extremo", R.drawable.sushi));
        PLATILLOS.add(new Saucer(9, "Sandwich Deli", R.drawable.sandwich));
        PLATILLOS.add(new Saucer(34f, "Lomo De Cerdo Austral", R.drawable.lomo_cerdo));

        BEBIDAS.add(new Saucer(3, "Taza de Café", R.drawable.cafe));
        BEBIDAS.add(new Saucer(12, "Coctel Tronchatoro", R.drawable.coctel));
        BEBIDAS.add(new Saucer(5, "Jugo Natural", R.drawable.jugo_natural));
        BEBIDAS.add(new Saucer(24, "Coctel Jordano", R.drawable.coctel_jordano));
        BEBIDAS.add(new Saucer(30, "Botella Vino Tinto Darius", R.drawable.vino_tinto));

        POSTRES.add(new Saucer(2, "Postre De Vainilla", R.drawable.postre_vainilla));
        POSTRES.add(new Saucer(3, "Flan Celestial", R.drawable.flan_celestial));
        POSTRES.add(new Saucer(2.5f, "Cupcake Festival", R.drawable.cupcakes_festival));
        POSTRES.add(new Saucer(4, "Pastel De Fresa", R.drawable.pastel_fresa));
        POSTRES.add(new Saucer(5, "Muffin Amoroso", R.drawable.muffin_amoroso));
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
