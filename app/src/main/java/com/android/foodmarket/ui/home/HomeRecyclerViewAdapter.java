package com.android.foodmarket.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.foodmarket.LoginActivity;
import com.android.foodmarket.R;
import com.android.foodmarket.RegisterActivity;
import com.android.foodmarket.models.Saucer;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    private View.OnClickListener listener;
    private final Context context;

    public HomeRecyclerViewAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_item_list, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Saucer item = Saucer.COMIDAS_POPULARES.get(position);

        Glide.with(holder.itemView.getContext())
                .load(item.getImage())
                .centerCrop()
                .into(holder.imagen);
        holder.nombre.setText(item.getName());
        holder.precio.setText("$" + String.format("%,.2f", item.getPrice()));
    }

    @Override
    public int getItemCount() {
        return Saucer.COMIDAS_POPULARES.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick((view));
        }
        else{
            Intent intent = new Intent(context, RegisterActivity.class);
            context.startActivity(intent);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView precio;
        public ImageView imagen;

        public ViewHolder(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.nombre_comida);
            precio = (TextView) view.findViewById(R.id.precio_comida);
            imagen = (ImageView) view.findViewById(R.id.miniatura_comida);
        }

    }

}
