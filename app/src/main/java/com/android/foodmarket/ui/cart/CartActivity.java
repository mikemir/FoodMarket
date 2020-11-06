package com.android.foodmarket.ui.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.foodmarket.R;
import com.android.foodmarket.models.Cart;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    RecyclerView rvCart;
    LinearLayout llCartEmpty;
    TextView tvQuantifyItems, tvTotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        getSupportActionBar().setTitle("Carrito de compras ("+Cart.ITEMS.size()+")");

        tvQuantifyItems = (TextView) findViewById(R.id.tvQuantifyItems);
        tvQuantifyItems.setText("x"+ Cart.getCount());
        tvTotalAmount = (TextView) findViewById(R.id.tvTotalAmount);
        tvTotalAmount.setText("Total: " + "$" + String.format("%,.2f", Cart.getTotalAmount()));

        llCartEmpty = (LinearLayout) findViewById(R.id.llCartEmpty);
        rvCart = (RecyclerView) findViewById(R.id.rvShopCart);

        if(Cart.ITEMS.size() == 0){
            llCartEmpty.setVisibility(View.VISIBLE);
            rvCart.setVisibility(View.GONE);
        }
        else{
            rvCart.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));
            rvCart.setAdapter(new CartRecyclerViewAdapter(this.getBaseContext(), new ArrayList<>(Cart.ITEMS.values())));
            llCartEmpty.setVisibility(View.GONE);
            rvCart.setVisibility(View.VISIBLE);
        }
    }

}