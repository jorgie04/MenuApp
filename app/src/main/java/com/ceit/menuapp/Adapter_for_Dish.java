package com.ceit.menuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import java.util.ArrayList;

public class Adapter_for_Dish extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {
            // Dishes
            R.drawable.grilled_chicken,
            R.drawable.fried_chicken,
            R.drawable.chicken_adobo,
            R.drawable.grilled_pork,
            R.drawable.porkchop,
            R.drawable.lechon_kawali,
            R.drawable.grilled_steak,
            R.drawable.beef_fillet,
            R.drawable.corned_beef,
            // Drinks
            R.drawable.deakin,
            R.drawable.matua,
            R.drawable.codorniu,
            R.drawable.coca_cola,
            R.drawable.fanta,
            R.drawable.pepsi
    };

    private ArrayList<String> orderDishes;

    public Adapter_for_Dish(Context context, ArrayList<String> orderDishes) {
        this.context = context;
        this.orderDishes = orderDishes;
    }

    @Override
    public int getCount() {
        return images.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout_for_dish, null);
        ImageView imageView = view.findViewById(R.id.imageView_dish);
        imageView.setImageResource(images[position]);

        view.setOnClickListener(view1 -> {
            String new_order;
            if (position == 0) {
                new_order = "Grilled Chicken";
            } else if (position == 1) {
                new_order = "Fried Chicken";
            } else if (position == 2) {
                new_order = "Chicken Adobo";
            } else if (position == 3) {
                new_order = "Grilled Pork";
            } else if (position == 4) {
                new_order = "Porkchop";
            } else if (position == 5) {
                new_order = "Lechon Kawali";
            } else if (position == 6) {
                new_order = "Grilled Steak";
            } else if (position == 7) {
                new_order = "Beef Fillet";
            } else if (position == 8) {
                new_order = "Corned Beef";
            } else if (position == 9) {
                new_order = "Deakin";
            } else if (position == 10) {
                new_order = "Matua";
            } else if (position == 11) {
                new_order = "Codorniu";
            } else if (position == 12) {
                new_order = "Coca Cola";
            } else if (position == 13) {
                new_order = "Fanta";
            } else if (position == 14) {
                new_order = "Pepsi";
            } else {
                new_order = "";
            }

            if (!new_order.isEmpty()) {
                Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show();
                orderDishes.add(new_order);
            }
        });

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }

    public ArrayList<String> getOrderDishes() {
        return orderDishes;
    }
}
