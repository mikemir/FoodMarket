package com.android.foodmarket.ui.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodmarket.R;
import com.android.foodmarket.models.Cart;
import com.android.foodmarket.models.CartItem;
import com.android.foodmarket.models.Saucer;
import com.android.foodmarket.ui.orders.OrdersRecyclerViewAdapter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<CartItem> items;
    private final Context context;

    CartRecyclerViewAdapter(Context context, ArrayList<CartItem> items){
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cart_item_list, parent, false);
        return new CartRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem item = items.get(position);
        Saucer saucer = item.getSaucer();

        holder.tvName.setText(saucer.getName());
        String description = context.getResources().getString(saucer.getDescription());
        int limitDescription = description.length() <= 100 ? description.length() : 100;
        holder.tvDescription.setText(description.substring(0, limitDescription - 1) + "...");
        holder.tvQuantify.setText("x"+ item.getQuantify());
        holder.tvPrice.setText("$" + String.format("%,.2f", item.getTotalPrice()));

        Glide.with(context)
                .load(saucer.getImage())
                .centerCrop()
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvDescription;
        public TextView tvQuantify;
        public TextView tvPrice;
        public ImageView ivImage;

        public ViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            tvQuantify = (TextView) view.findViewById(R.id.tvQuantify);
            tvPrice = (TextView) view.findViewById(R.id.tvMount);
            ivImage = (ImageView) view.findViewById(R.id.ivImage);
        }
    }
}
