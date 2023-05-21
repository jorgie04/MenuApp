package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class drinks_screen extends AppCompatActivity {

    ImageButton mainButton;
    ImageButton checkOut;
    ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_screen);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // View image "Adapter_for_drinks"
        viewpager = findViewById(R.id.viewPager_drinks);
        Adapter_for_drinks adapter = new Adapter_for_drinks(this);
        viewpager.setAdapter(adapter);

        // To go to Main Course screen
        mainButton = findViewById(R.id.mainButton);
        mainButton.setOnClickListener(view -> {

            Intent intent=new Intent(drinks_screen.this,order_Screen.class);
            startActivity(intent);
        });

        // To go to Check out screen
        checkOut = findViewById(R.id.checkOut);
        checkOut.setOnClickListener(view -> {

            Intent intent=new Intent(drinks_screen.this,check_out.class);
            startActivity(intent);
        });
    }
}