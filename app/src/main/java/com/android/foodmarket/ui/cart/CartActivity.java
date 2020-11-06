package com.android.foodmarket.ui.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.foodmarket.R;
import com.android.foodmarket.models.Cart;

public class CartActivity extends AppCompatActivity {

    RecyclerView rvCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        getSupportActionBar().setTitle("Carrito de compras.");

        rvCart = (RecyclerView) findViewById(R.id.rvShopCart);
        rvCart.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));
        rvCart.setAdapter(new CartRecyclerViewAdapter(this.getBaseContext(), Cart.ITEMS));
    }

}