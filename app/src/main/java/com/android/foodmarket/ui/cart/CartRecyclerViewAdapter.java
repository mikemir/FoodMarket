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

import java.util.List;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder> {

    private final List<CartItem> items;
    private final Context context;

    CartRecyclerViewAdapter(Context context, List<CartItem> items){
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
        Saucer item = items.get(position).getSaucer();

        holder.tvName.setText(item.getName());
        String description = context.getResources().getString(item.getDescription());
        int limitDescription = description.length() <= 75 ? description.length() : 75;
        holder.tvDescription.setText(description.substring(0, limitDescription - 1) + "...");
        holder.tvPrice.setText("$" + String.format("%,.2f", item.getPrice()));

        Glide.with(context)
                .load(item.getImage())
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
        public TextView tvPrice;
        public ImageView ivImage;

        public ViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            tvPrice = (TextView) view.findViewById(R.id.tvMount);
            ivImage = (ImageView) view.findViewById(R.id.ivImage);
        }
    }
}
