package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.AnimationTypes;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class drinks_screen extends AppCompatActivity {

    ImageButton mainButton;
    ImageButton checkOut;
    ImageSlider drinks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_screen);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // drinks
        drinks = findViewById(R.id.image_slider_drinks);
        ArrayList<SlideModel> beverage = new ArrayList<>();

        beverage.add(new SlideModel(R.drawable.deakin, "Deakin..........575", ScaleTypes.FIT));
        beverage.add(new SlideModel(R.drawable.codorniu, "Codorniu..........655", ScaleTypes.FIT));
        beverage.add(new SlideModel(R.drawable.matua, "Matua.........790", ScaleTypes.FIT));
        beverage.add(new SlideModel(R.drawable.fanta, "Fanta..........30", ScaleTypes.FIT));
        beverage.add(new SlideModel(R.drawable.cocacola, "Coca Cola..........30", ScaleTypes.FIT));
        beverage.add(new SlideModel(R.drawable.pepsi, "Pepsi.........30", ScaleTypes.FIT));

        drinks.setImageList(beverage, ScaleTypes.CENTER_CROP);
        drinks.setSlideAnimation(AnimationTypes.GATE);
        drinks.startSliding(3000); // 3 seconds before sliding to next slide
        drinks.stopSliding();

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