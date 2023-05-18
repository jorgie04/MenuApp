package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class check_out extends AppCompatActivity {

    ImageButton backButton;
    ImageButton confirmButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> {

            Intent intent=new Intent(check_out.this,drinks_screen.class);
            startActivity(intent);
        });

        confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(view -> {

        });


    }
}