package com.android.foodmarket.ui.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.foodmarket.MainActivity;
import com.android.foodmarket.R;
import com.android.foodmarket.models.Cart;
import com.android.foodmarket.ui.user.LoginActivity;

import org.w3c.dom.Text;

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

        updateDataCart();

        if(Cart.ITEMS.size() == 0){
            llCartEmpty.setVisibility(View.VISIBLE);
            rvCart.setVisibility(View.GONE);
        }
        else{
            fillReciclerViewWithItems();
            llCartEmpty.setVisibility(View.GONE);
            rvCart.setVisibility(View.VISIBLE);
        }
    }

    private void updateDataCart(){
        getSupportActionBar().setTitle("Carrito de compras ("+Cart.ITEMS.size()+")");
        tvQuantifyItems.setText("x"+ Cart.getCount());
        tvTotalAmount.setText("Total: " + "$" + String.format("%,.2f", Cart.getTotalAmount()));
    }

    private void fillReciclerViewWithItems(){
        rvCart.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));
        rvCart.setAdapter(new CartRecyclerViewAdapter(this.getBaseContext(), new ArrayList<>(Cart.ITEMS.values())));
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
                                    fillReciclerViewWithItems();
                                    updateDataCart();
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
        Toast.makeText(getBaseContext(), "Proceder a su pago.", Toast.LENGTH_LONG).show();
    }
}