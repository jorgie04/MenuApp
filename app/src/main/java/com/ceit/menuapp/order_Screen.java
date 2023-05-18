package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class order_Screen extends AppCompatActivity {

    ImageButton drinks;
    ImageButton checkOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // To go to Drinks Screen
        drinks = findViewById(R.id.drinks);
        drinks.setOnClickListener(view -> {

            Intent intent=new Intent(order_Screen.this,drinks_screen.class);
            startActivity(intent);
        });

        // To go to Check out Screen
        checkOut = findViewById(R.id.checkOut);
        checkOut.setOnClickListener(view -> {

            Intent intent=new Intent(order_Screen.this, check_out.class);
            startActivity(intent);
        });

    }
}