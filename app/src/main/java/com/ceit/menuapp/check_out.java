package com.ceit.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class check_out extends AppCompatActivity {

    ImageButton backButton;
    ImageButton confirmButton;
    TextView orderDetails;

    EditText customerName;
    EditText customerAddress;
    EditText customerContact;

    FirebaseFirestore firestore;

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
            Intent intent = new Intent(check_out.this, drinks_screen.class);
            startActivity(intent);
        });

        customerName = findViewById(R.id.editTextCustomerName);
        customerAddress = findViewById(R.id.editTextCustomerAddress);
        customerContact = findViewById(R.id.editTextCustomerContact);

        confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(view -> {
            // Handle confirm button click

            firestore = FirebaseFirestore.getInstance();

            Intent intent = getIntent();
            ArrayList<String> orderDishes = intent.getStringArrayListExtra("orderDishes");


            Map<String, Object> orders =  new HashMap<>();

            if (orderDishes != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String dish : orderDishes) {
                    stringBuilder.append("Dish ").append(dish).append(", ");
                }
                orders.put("items", stringBuilder.toString());
            }

            orders.put("customer_name", customerName.getText().toString());
            orders.put("customer_address", customerAddress.getText().toString());
            orders.put("customer_contact", customerContact.getText().toString());

            firestore.collection("orders").add(orders).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                }
            });


        });

        orderDetails = findViewById(R.id.orderDetails);

        Intent intent = getIntent();
        ArrayList<String> orderDishes = intent.getStringArrayListExtra("orderDishes");

        if (orderDishes != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String dish : orderDishes) {
                stringBuilder.append("Dish ").append(dish).append("\n");
            }
            orderDetails.setText(stringBuilder.toString());
        }
    }
}
