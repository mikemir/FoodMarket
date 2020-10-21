package com.android.foodmarket.ui.orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodmarket.R;

public class OrdersFragment extends Fragment {

    private OrdersViewModel catalogViewModel;
    RecyclerView rvOrders;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        catalogViewModel = new ViewModelProvider(this).get(OrdersViewModel.class);

        View root = inflater.inflate(R.layout.fragment_orders, container, false);

        rvOrders = root.findViewById(R.id.rvOrders);
        rvOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvOrders.setAdapter(new OrdersRecyclerViewAdapter());

        return root;
    }
}