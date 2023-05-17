package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class drinks_screen extends AppCompatActivity {

    ImageButton mainButton;
    ImageButton checkOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_screen);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mainButton = findViewById(R.id.mainButton);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(drinks_screen.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}