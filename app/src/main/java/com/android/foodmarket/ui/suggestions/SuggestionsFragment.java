package com.android.foodmarket.ui.suggestions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.foodmarket.R;

public class SuggestionsFragment extends Fragment implements View.OnClickListener {

    private SuggestionsViewModel suggestionsViewModel;
    private EditText etSuggestion;
    private Button btSendSuggestion;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        suggestionsViewModel = new ViewModelProvider(this).get(SuggestionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_suggestions, container, false);

        etSuggestion = (EditText) root.findViewById(R.id.etSuggestion);
        btSendSuggestion = (Button) root.findViewById(R.id.btSendSuggestion);

        btSendSuggestion.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        String suggestion = etSuggestion.getText().toString();

        if (suggestion.length() <= 0) {
            etSuggestion.setError("El campo es requerido.");
            etSuggestion.requestFocus();
            return;
        }

        Toast.makeText(this.getContext(), "Su sugerencia a sido enviada. Muchas gracias por su sugerencias", Toast.LENGTH_LONG).show();
        etSuggestion.setText("");
    }
}