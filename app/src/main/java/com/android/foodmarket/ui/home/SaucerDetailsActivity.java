package com.android.foodmarket.ui.home;

import android.content.Intent;
import android.os.Bundle;

import com.android.foodmarket.MainActivity;
import com.android.foodmarket.R;
import com.android.foodmarket.models.Cart;
import com.android.foodmarket.models.CartItem;
import com.android.foodmarket.models.Saucer;
import com.android.foodmarket.ui.cart.CartActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SaucerDetailsActivity extends AppCompatActivity {

    TextView tvName, tvAmount, tvDescription;
    ImageView ivImage;
    FloatingActionButton btAddCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saucer_details);
        Gson json = new Gson();
        String saucerJson = getIntent().getStringExtra("itemSaucer");
        Saucer item = json.fromJson(saucerJson, Saucer.class);

        ivImage = findViewById(R.id.ivImage);
        Glide.with(this)
                .load(item.getImage())
                .centerCrop()
                .into(ivImage);

        tvName = (TextView) findViewById(R.id.tvName);
        tvName.setText(item.getName());

        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvDescription.setText(item.getDescription() > 0
                              ? getResources().getString(item.getDescription())
                              : "");

        tvAmount = (TextView) findViewById(R.id.tvMount);
        tvAmount.setText("Monto: $" + String.format("%,.2f", item.getPrice()));

        btAddCart = findViewById(R.id.btAddCart);
        btAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart.addItem(new CartItem(item, 1));
                Snackbar.make(view, "El platillo " + item.getName() + "a sido agreado a tu carrito de compras.", BaseTransientBottomBar.LENGTH_LONG)
                        .setAction("Carrito", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(SaucerDetailsActivity.this, CartActivity.class);
                                startActivity(intent);
                            }
                        }).show();
            }
        });
    }
}