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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SaucerDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvName, tvAmount, tvDescription;
    EditText etQuantify;
    ImageView ivImage;
    ImageButton btQuantifyMinus, btQuantifyPlus;
    FloatingActionButton btAddCart;
    Saucer selectedItem;
    int quantify = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saucer_details);
        Gson json = new Gson();
        String saucerJson = getIntent().getStringExtra("itemSaucer");
        selectedItem = json.fromJson(saucerJson, Saucer.class);

        ivImage = findViewById(R.id.ivImage);
        Glide.with(this)
                .load(selectedItem.getImage())
                .centerCrop()
                .into(ivImage);

        tvName = (TextView) findViewById(R.id.tvName);
        tvName.setText(selectedItem.getName());

        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvDescription.setText(selectedItem.getDescription() > 0
                ? getResources().getString(selectedItem.getDescription())
                : "");

        tvAmount = (TextView) findViewById(R.id.tvMount);
        tvAmount.setText("Monto: $" + String.format("%,.2f", selectedItem.getPrice()));

        etQuantify = (EditText) findViewById(R.id.etQuantify);
        etQuantify.setText(Integer.toString(quantify));

        btQuantifyMinus = (ImageButton) findViewById(R.id.btQuantifyMinus);
        btQuantifyMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantify > 1){
                    quantify--;
                    etQuantify.setText(Integer.toString(quantify));
                    tvAmount.setText("Monto: $" + String.format("%,.2f", selectedItem.getPrice() * quantify));
                }
            }
        });

        btQuantifyPlus = (ImageButton) findViewById(R.id.btQuantifyplus);
        btQuantifyPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantify <= 99){
                    quantify++;
                    etQuantify.setText(Integer.toString(quantify));
                    tvAmount.setText("Monto: $" + String.format("%,.2f", selectedItem.getPrice() * quantify));
                }
            }
        });

        btAddCart = findViewById(R.id.btAddCart);
        btAddCart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Cart.addItem(new CartItem(selectedItem, Integer.parseInt(etQuantify.getText().toString())));
        Snackbar.make(view, "El platillo " + selectedItem.getName() + "a sido agreado a tu carrito de compras.", BaseTransientBottomBar.LENGTH_LONG)
                .setAction("Carrito", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SaucerDetailsActivity.this, CartActivity.class);
                        startActivity(intent);
                    }
                }).show();
    }
}