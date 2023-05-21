package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class order_Screen extends AppCompatActivity {

    ImageButton drinks;
    ImageButton checkOut;

    ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // View image "Adapter_for_Dish"
        viewpager = findViewById(R.id.viewPager);
        Adapter_for_Dish adapter = new Adapter_for_Dish(this);
        viewpager.setAdapter(adapter);

        // To go to Drinks Screen
        drinks = findViewById(R.id.drinks_button);
        drinks.setOnClickListener(view -> {

            Intent intent=new Intent(order_Screen.this,drinks_screen.class);
            startActivity(intent);
        });

        // To go to Check out Screen
        checkOut = findViewById(R.id.checkout);
        checkOut.setOnClickListener(view -> {

            Intent intent=new Intent(order_Screen.this, check_out.class);
            startActivity(intent);
        });
    }
}