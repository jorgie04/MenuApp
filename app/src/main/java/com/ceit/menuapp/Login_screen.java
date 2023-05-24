package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Login_screen extends AppCompatActivity {

    ImageButton login;
    ImageButton sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Login Button
        login = findViewById(R.id.login_Button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_screen.this, order_Screen.class);
                startActivity(intent);
            }
        });

        // Sign up Button
        sign_up = findViewById(R.id.signup_Button);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_screen.this, signUp_screen.class);
                startActivity(intent);
            }
        });
    }
}