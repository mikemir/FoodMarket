package com.android.foodmarket.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodmarket.R;
import com.android.foodmarket.SaucerDetailsActivity;
import com.android.foodmarket.models.Saucer;
import com.google.gson.Gson;

import java.util.List;

public class HomeFragment extends Fragment implements HomeRecyclerViewAdapter.RecyclerViewOnClickListener {

    private HomeViewModel homeViewModel;
    private RecyclerView rvComidas;
    private List<Saucer> listSaucers;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        listSaucers = Saucer.BEBIDAS;

        rvComidas = root.findViewById(R.id.rvFood);
        rvComidas.setLayoutManager(new LinearLayoutManager(getActivity()));
        HomeRecyclerViewAdapter adapter = new HomeRecyclerViewAdapter(root.getContext(), listSaucers);
        adapter.setOnClickListener(this);
        rvComidas.setAdapter(adapter);

        return root;
    }

    @Override
    public void onClick(View view, int position) {
        Gson json = new Gson();
        Saucer item = listSaucers.get(position);

        Intent intent = new Intent(this.getContext(), SaucerDetailsActivity.class);
        intent.putExtra("itemSaucer", json.toJson(item));
        startActivity(intent);
    }
}