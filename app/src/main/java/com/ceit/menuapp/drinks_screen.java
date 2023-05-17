package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class drinks_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_screen);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}