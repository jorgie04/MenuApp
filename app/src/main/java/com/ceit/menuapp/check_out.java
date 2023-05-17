package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class check_out extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


    }
}