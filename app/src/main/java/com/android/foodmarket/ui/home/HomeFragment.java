package com.android.foodmarket.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodmarket.R;
import com.android.foodmarket.models.Saucer;
import com.google.gson.Gson;

import java.util.List;

public class HomeFragment extends Fragment implements HomeRecyclerViewAdapter.RecyclerViewOnClickListener {

    private HomeViewModel homeViewModel;
    private RecyclerView rvComidas;
    private List<Saucer> listSaucers;
    private Spinner spListMenu;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        rvComidas = root.findViewById(R.id.rvFood);

        spListMenu = (Spinner) root.findViewById(R.id.spListMenu);
        spListMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        listSaucers = Saucer.PLATILLOS;
                        break;
                    case 1:
                        listSaucers = Saucer.BEBIDAS;
                        break;
                    case 2:
                        listSaucers = Saucer.POSTRES;
                        break;
                }
                setListOnRecycler(view, listSaucers);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return root;
    }

    public void setListOnRecycler(View view, List<Saucer> listSaucers){
        rvComidas.setLayoutManager(new LinearLayoutManager(getActivity()));
        HomeRecyclerViewAdapter adapter = new HomeRecyclerViewAdapter(view.getContext(), listSaucers);
        adapter.setOnClickListener(this);
        rvComidas.setAdapter(adapter);
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