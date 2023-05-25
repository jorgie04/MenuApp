package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class customer_details extends AppCompatActivity {

    EditText customerName;
    EditText customerAddress;
    EditText customerContact;

    ImageButton back;
    ImageButton confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        customerName = findViewById(R.id.editTextCustomerName);
        customerAddress = findViewById(R.id.editTextCustomerAddress);
        customerContact = findViewById(R.id.editTextCustomerContact);

        back = findViewById(R.id.back_Button);
        confirm = findViewById(R.id.confirm_Button);

        back.setOnClickListener(view -> {

            Intent intent = new Intent(customer_details.this, check_out.class);
            startActivity(intent);
        });

        confirm.setOnClickListener(view -> {

            Intent intent = new Intent(customer_details.this, OrderConfirmed.class);
            startActivity(intent);
        });
    }
}