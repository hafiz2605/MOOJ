package com.example.intag.slider1;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

/**
 * Created by Intag on 1/28/2018.
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    //images list
    public int[] list_img = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
    };
    //Titles list
    public String[] list_titles = {
           "Components",
            "Satelites",
            "Uber",
            "Map"
    };
    //Descriptions list
    public String[] list_desc = {
            "Description 1",
            "Description 2",
            "Description 3",
            "Description 4"
    };
    //Colors list
    public int[] list_colors = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,21)
    };

    public SliderAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_titles.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sliderpage,container,false);
        LinearLayout layoutslider = (LinearLayout) view.findViewById(R.id.sliderviewlayout);
        ImageView image = (ImageView) view.findViewById(R.id.slideimg);
        TextView title = (TextView) view.findViewById(R.id.txttile);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslider.setBackgroundColor(list_colors[position]);
        image.setImageResource(list_img[position]);
        title.setText(list_titles[position]);
        description.setText(list_desc[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
