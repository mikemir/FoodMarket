package com.android.foodmarket.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.foodmarket.R;
import com.android.foodmarket.SaucerDetailsActivity;
import com.android.foodmarket.models.Saucer;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    private RecyclerViewOnClickListener listener;
    private final Context context;
    private List<Saucer> listSaucers;

    public HomeRecyclerViewAdapter(Context context, List<Saucer> list){
        this.context = context;
        this.listSaucers = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Saucer item = listSaucers.get(position);

        Glide.with(holder.itemView.getContext())
                .load(item.getImage())
                .centerCrop()
                .into(holder.imagen);
        holder.nombre.setText(item.getName());
        holder.precio.setText("$" + String.format("%,.2f", item.getPrice()));
    }

    @Override
    public int getItemCount() {
        return listSaucers.size();
    }

    public void setOnClickListener(RecyclerViewOnClickListener listener){
        this.listener = listener;
    }

    public interface RecyclerViewOnClickListener{
        void onClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView precio;
        public ImageView imagen;

        public ViewHolder(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.nombre_comida);
            precio = (TextView) view.findViewById(R.id.precio_comida);
            imagen = (ImageView) view.findViewById(R.id.miniatura_comida);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

}
