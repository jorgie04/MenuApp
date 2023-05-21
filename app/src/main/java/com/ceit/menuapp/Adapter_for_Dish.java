package com.ceit.menuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class Adapter_for_Dish extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {
            R.drawable.dish_one,
            R.drawable.fried_chicken,
            R.drawable.chicken_adobo,
            R.drawable.dish_two,
            R.drawable.pork_chop,
            R.drawable.lechon_kawali,
            R.drawable.grilled_steak,
            R.drawable.dish_three,
            R.drawable.corned_beef
    };

    public Adapter_for_Dish(Context context){

        this.context = context;
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
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView_dish);
        imageView.setImageResource(images[position]);

        // Image clickable
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0){
                    Toast.makeText(context, "PAGOD", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(context, "NA", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(context, "AKO", Toast.LENGTH_SHORT).show();
            }
        });

        ViewPager viewpage =(ViewPager) container;
        viewpage.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager viewpage = (ViewPager) container;
        View view = (View) object;
        viewpage.removeView(view);
    }
}
