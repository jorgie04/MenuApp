package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.List;

import app.num.numandroidpagecurleffect.PageCurlView;

public class order_Screen extends AppCompatActivity {

    ImageButton drinks;
    ImageButton checkOut;
    PageCurlView pageCurlView;
    List<Integer> dishes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        pageCurlView = findViewById(R.id.pagecurlView);
        dishes= new ArrayList<>();

        dishes.add(R.drawable.dish_one); // First Dish
        dishes.add(R.drawable.dish_two); // Second Dish
        dishes.add(R.drawable.dish_three); // Third Dish

        pageCurlView.setCurlView(dishes);
        pageCurlView.setCurlSpeed(600);

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