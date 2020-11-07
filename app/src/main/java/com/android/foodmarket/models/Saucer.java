package com.android.foodmarket.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import  com.android.foodmarket.R;

public class Saucer {
    private String id;
    private String name;
    private int description;
    private double price;
    private int image;

    public Saucer(double price, String name, int image){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Saucer(double price, String name, int image, int description){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public static final List<Saucer> BEBIDAS = new ArrayList<>();
    public static final List<Saucer> POSTRES = new ArrayList<>();
    public static final List<Saucer> PLATILLOS = new ArrayList<>();

    static {
        PLATILLOS.add(new Saucer(1.5, "Pupusas tradicionales", R.drawable.pupusas, R.string.description_pupusas));
        PLATILLOS.add(new Saucer(5, "Camarones al Ajillo", R.drawable.camarones, R.string.description_camarones));
        PLATILLOS.add(new Saucer(3.2f, "Rosca de frutas", R.drawable.rosca, R.string.description_rosca));
        PLATILLOS.add(new Saucer(12f, "Sushi Extremo", R.drawable.sushi, R.string.description_sushi));
        PLATILLOS.add(new Saucer(9, "Sandwich Deli", R.drawable.sandwich, R.string.description_sandwich));
        PLATILLOS.add(new Saucer(34f, "Lomo De Cerdo Austral", R.drawable.lomo_cerdo, R.string.description_lomo));

        BEBIDAS.add(new Saucer(3, "Taza de Café", R.drawable.cafe, R.string.description_cafe));
        BEBIDAS.add(new Saucer(12, "Coctel Tronchatoro", R.drawable.coctel, R.string.description_coctel));
        BEBIDAS.add(new Saucer(5, "Jugo Natural", R.drawable.jugo_natural, R.string.description_jugo));
        BEBIDAS.add(new Saucer(24, "Coctel Jordano", R.drawable.coctel_jordano, R.string.description_cocteljordano));
        BEBIDAS.add(new Saucer(30, "Botella Vino Tinto Darius", R.drawable.vino_tinto, R.string.description_vinotinto));

        POSTRES.add(new Saucer(2, "Postre De Vainilla", R.drawable.postre_vainilla, R.string.description_postrevainilla));
        POSTRES.add(new Saucer(3, "Flan Celestial", R.drawable.flan_celestial, R.string.description_flancelestial));
        POSTRES.add(new Saucer(2.5f, "Cupcake Festival", R.drawable.cupcakes_festival, R.string.description_cupcake));
        POSTRES.add(new Saucer(4, "Pastel De Fresa", R.drawable.pastel_fresa, R.string.description_pastelfresa));
        POSTRES.add(new Saucer(5, "Muffin Amoroso", R.drawable.muffin_amoroso, R.string.description_muffinamoroso));
    }

    public String getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public String getId() {
        return id;
    }
}
