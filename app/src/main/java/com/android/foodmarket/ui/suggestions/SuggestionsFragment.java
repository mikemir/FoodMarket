package com.android.foodmarket.ui.suggestions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.foodmarket.R;

public class SuggestionsFragment extends Fragment {

    private SuggestionsViewModel suggestionsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        suggestionsViewModel = new ViewModelProvider(this).get(SuggestionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_suggestions, container, false);

        return root;
    }
}