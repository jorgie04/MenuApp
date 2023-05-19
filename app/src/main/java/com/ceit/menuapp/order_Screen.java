package com.ceit.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.constants.AnimationTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;

public class order_Screen extends AppCompatActivity {

    ImageButton drinks;
    ImageButton checkOut;
    ImageSlider dishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        // To hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // dishes
        dishes = findViewById(R.id.image_slider);
        ArrayList<SlideModel> dish = new ArrayList<>();

        dish.add(new SlideModel(R.drawable.dish_one, "Grilled Chicken..........175",ScaleTypes.CENTER_CROP));
        dish.add(new SlideModel(R.drawable.fried_chicken, "Fried Chicken..........150",ScaleTypes.CENTER_CROP));
        dish.add(new SlideModel(R.drawable.chicken_adobo, "Chicken Adobo..........180",ScaleTypes.CENTER_CROP));
        dish.add(new SlideModel(R.drawable.dish_two, "Grilled Pork..........250",ScaleTypes.CENTER_CROP));
        dish.add(new SlideModel(R.drawable.pork_chop, "Porkchop..........300",ScaleTypes.CENTER_CROP));
        dish.add(new SlideModel(R.drawable.lechon_kawali, "Lechon Kawali..........125",ScaleTypes.CENTER_CROP));
        dish.add(new SlideModel(R.drawable.grilled_steak, "Grilled Steak..........350",ScaleTypes.CENTER_CROP));
        dish.add(new SlideModel(R.drawable.dish_three, "Beef Fillet..........200",ScaleTypes.CENTER_CROP));
        dish.add(new SlideModel(R.drawable.corned_beef, "Corned Beef..........250",ScaleTypes.CENTER_CROP));

        dishes.setImageList(dish, ScaleTypes.CENTER_CROP);
        dishes.setSlideAnimation(AnimationTypes.GATE); // slides animation
        dishes.startSliding(3000); // 3 seconds before sliding to next slide
        dishes.stopSliding();

        dishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Hindi ko magawa, pagod na ako.
            }
        });

        // To go to Drinks Screen
        drinks = findViewById(R.id.drinks_button);
        drinks.setOnClickListener(view -> {

            Intent intent=new Intent(order_Screen.this,drinks_screen.class);
            startActivity(intent);
        });

        // To go to Check out Screen
        checkOut = findViewById(R.id.checkout);
        checkOut.setOnClickListener(view -> {

            Intent intent=new Intent(order_Screen.this, check_out.class);
            startActivity(intent);
        });
    }
}