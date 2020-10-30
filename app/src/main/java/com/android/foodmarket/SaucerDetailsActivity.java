package com.android.foodmarket;

import android.content.Intent;
import android.os.Bundle;

import com.android.foodmarket.models.Saucer;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class SaucerDetailsActivity extends AppCompatActivity {

    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saucer_details);
        Gson json = new Gson();
        String saucerJson = getIntent().getStringExtra("itemSaucer");
        Saucer item = json.fromJson(saucerJson, Saucer.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(item.getName());

        toolBarLayout.setBackground(getResources().getDrawable(item.getImage()));

        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvDescription.setText(saucerJson);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}