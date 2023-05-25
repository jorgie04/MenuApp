package com.ceit.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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

    TextView totalAmount;

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
            Intent intent = new Intent(check_out.this, order_Screen.class);
            startActivity(intent);
        });

        customerName = findViewById(R.id.editTextCustomerName);
        customerAddress = findViewById(R.id.editTextCustomerAddress);
        customerContact = findViewById(R.id.editTextCustomerContact);
        orderDetails = findViewById(R.id.orderDetails);

        orderDetails.setMovementMethod(new ScrollingMovementMethod());

        totalAmount = findViewById(R.id.totalAmount);

        confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(view -> {
            // Handle confirm button click
            Intent nextIntent=new Intent(check_out.this, OrderConfirmed.class);
            startActivity(nextIntent);

            firestore = FirebaseFirestore.getInstance();

            Intent intent = getIntent();
            ArrayList<String> orderDishes = intent.getStringArrayListExtra("orderDishes");


            Map<String, Object> orders =  new HashMap<>();

            if (orderDishes != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String dish : orderDishes) {
                    stringBuilder.append(dish).append(", ");
                }
                orders.put("items", stringBuilder.toString());
            }

            orders.put("customer_name", customerName.getText().toString());
            orders.put("customer_address", customerAddress.getText().toString());
            orders.put("customer_contact", customerContact.getText().toString());

            firestore.collection("orders").add(orders).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            });

        });

        Intent intent = getIntent();
        ArrayList<String> orderDishes = intent.getStringArrayListExtra("orderDishes");

        if (orderDishes != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String dish : orderDishes) {
                stringBuilder.append(dish).append("\n");
            }
            orderDetails.setText(stringBuilder.toString());
        }

        int total = 0;

        for (String dish : orderDishes) {
            if (dish.equals("Grilled Chicken")) {
                total += 175;
            } else if (dish.equals("Fried Chicken")) {
                total += 150;
            } else if (dish.equals("Chicken Adobo")) {
                total += 180;
            } else if (dish.equals("Grilled Pork")) {
                total += 250;
            } else if (dish.equals("Porkchop")) {
                total += 300;
            } else if (dish.equals("Lechon Kawali")) {
                total += 125;
            } else if (dish.equals("Grilled Steak")) {
                total += 350;
            } else if (dish.equals("Beef Fillet")) {
                total += 200;
            } else if (dish.equals("Corned Beef")) {
                total += 250;
            } else if (dish.equals("Deakin")) {
                total += 575;
            } else if (dish.equals("Matua")) {
                total += 790;
            } else if (dish.equals("Codorniu")) {
                total += 655;
            } else if (dish.equals("Coca Cola")) {
                total += 30;
            } else if (dish.equals("Fanta")) {
                total += 30;
            } else if (dish.equals("Pepsi")) {
                total += 30;
            }

        }

        String totalText = "Total: ";
        String totalInt = Integer.toString(total);
        String returnText = totalText + totalInt;

        totalAmount.setText(returnText);
    }
}
