package com.example.intag.slider1;

import android.app.ActivityManager;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class SliderView extends AppCompatActivity {
    private ViewPager viewPager;
    private SliderAdapter adapter;
    public static int currentpages = 0;
    public static int numpages = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_view);
        viewPager =  (ViewPager) findViewById(R.id.viewpager);
        adapter = new SliderAdapter(this);
        viewPager.setAdapter(adapter);

        //indicator view
        CircleIndicator circleindicator = (CircleIndicator) findViewById(R.id.indicator);
        circleindicator.setViewPager(viewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentpages=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state==viewPager.SCROLL_STATE_IDLE){
                    int pagecount = adapter.getCount();
                    if(currentpages==0){
                        viewPager.setCurrentItem(pagecount-1,false);
                    }else if(currentpages==pagecount-1){
                       new android.os.Handler().postDelayed(
                               new Runnable() {
                                    public void run() {
                                        viewPager.setCurrentItem(0,false);
                                   }
                                },
                                2000);
                    }
                }
            }
        });

     //timer for slider
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentpages==numpages){
                                    currentpages=0;

                }
                viewPager.setCurrentItem(currentpages++,true);
            }
        };
        Timer swipe = new Timer();
        swipe.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },2000,1000);



    }
}
