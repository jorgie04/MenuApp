package com.ceit.menuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

     ImageButton buttonToOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        buttonToOrder = findViewById(R.id.buttonToOrder);
        buttonToOrder.setOnClickListener(view -> {

                Intent intent=new Intent(MainActivity.this,order_Screen.class);
                startActivity(intent);
        });
    }
}