package com.android.foodmarket.ui.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.foodmarket.R;
import com.android.foodmarket.models.Cart;
import com.android.foodmarket.models.CartItem;
import com.android.foodmarket.ui.home.HomeRecyclerViewAdapter;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rvCart;
    LinearLayout llCartEmpty;
    TextView tvQuantifyItems, tvTotalAmount;
    Button btGoToPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tvQuantifyItems = (TextView) findViewById(R.id.tvQuantifyItems);
        tvTotalAmount = (TextView) findViewById(R.id.tvTotalAmount);
        llCartEmpty = (LinearLayout) findViewById(R.id.llCartEmpty);
        rvCart = (RecyclerView) findViewById(R.id.rvShopCart);
        btGoToPay = (Button) findViewById(R.id.btGoToPay);

        updateDataShoppingCart();
        btGoToPay.setOnClickListener(this);

        if(Cart.ITEMS.size() == 0){
            llCartEmpty.setVisibility(View.VISIBLE);
            rvCart.setVisibility(View.GONE);
        }
        else{
            fillRecyclerViewWithItems();
            llCartEmpty.setVisibility(View.GONE);
            rvCart.setVisibility(View.VISIBLE);
        }
    }

    private void updateDataShoppingCart(){
        getSupportActionBar().setTitle("Carrito de compras ("+Cart.ITEMS.size()+")");
        tvQuantifyItems.setText("x"+ Cart.getCount());
        tvTotalAmount.setText("Total: " + "$" + String.format("%,.2f", Cart.getTotalAmount()));
    }

    private void fillRecyclerViewWithItems(){
        rvCart.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));
        CartRecyclerViewAdapter adapter = new CartRecyclerViewAdapter(this.getBaseContext(), Cart.ITEMS);
        adapter.setOnClickListener(new HomeRecyclerViewAdapter.RecyclerViewOnClickListener() {
            @Override
            public void onClick(View view, int position) {
                CartItem item = Cart.ITEMS.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);
                builder.setTitle("Eliminar platillo.")
                        .setMessage("¿Desea eliminar el platillo " + item.getSaucer().getName() +"?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Cart.removeItem(position);
                                fillRecyclerViewWithItems();
                                updateDataShoppingCart();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.create().show();
            }
        });
        rvCart.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btClear:

                AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);
                builder.setTitle("Limpiar carrito.")
                        .setMessage("¿Desea eliminar todos los platillos?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Cart.getCount() != 0){
                                    Cart.clear();
                                    fillRecyclerViewWithItems();
                                    updateDataShoppingCart();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.create().show();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cart_activity, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        String message = Cart.getCount() > 0
                        ? "Puede proceder a su pago."
                        : "Aún no tienes ningún platillo agregado.";

        Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
    }
}