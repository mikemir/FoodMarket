package com.android.foodmarket.ui.orders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodmarket.R;
import com.android.foodmarket.models.Order;
import com.android.foodmarket.models.Saucer;
import com.android.foodmarket.ui.home.HomeRecyclerViewAdapter;

import java.text.SimpleDateFormat;

public class OrdersRecyclerViewAdapter extends RecyclerView.Adapter<OrdersRecyclerViewAdapter.ViewHolder>{


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_orders_item_list, parent, false);
        return new OrdersRecyclerViewAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        Order item = Order.ORDERS.get(position);

        holder.numeroPedido.setText("#" + String.format("%03d", item.getId()));
        holder.fechaPedido.setText("Fecha del pedido: " +  format.format(item.getCreationDate()));
        holder.cantidadPedido.setText("Cantidad: " + item.getQuantity() + " items");
        holder.montoPedido.setText("Monto: $" + String.format("%,.2f", item.getTotalAmount()));
    }

    @Override
    public int getItemCount() {
        return Order.ORDERS.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView numeroPedido;
        public TextView fechaPedido;
        public TextView montoPedido;
        public TextView cantidadPedido;

        public ViewHolder(View view) {
            super(view);
            numeroPedido = (TextView) view.findViewById(R.id.tvNumPedido);
            fechaPedido = (TextView) view.findViewById(R.id.tvFechaPedido);
            montoPedido = (TextView) view.findViewById(R.id.tvMontoPedido);
            cantidadPedido = (TextView) view.findViewById(R.id.tvCantidadPedido);
        }
    }
}
