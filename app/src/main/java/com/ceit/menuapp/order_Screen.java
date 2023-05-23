package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class order_Screen extends AppCompatActivity {

    ImageButton checkOut;
    ViewPager viewpager;
    private ArrayList<String> orderDishes = new ArrayList<>();

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
        Adapter_for_Dish adapter = new Adapter_for_Dish(this, orderDishes);
        viewpager.setAdapter(adapter);


        // To go to Check out Screen
        checkOut = findViewById(R.id.checkout);
        checkOut.setOnClickListener(view -> {
            Intent intent = new Intent(order_Screen.this, check_out.class);
            intent.putStringArrayListExtra("orderDishes", orderDishes);
            startActivity(intent);
        });
    }
}
