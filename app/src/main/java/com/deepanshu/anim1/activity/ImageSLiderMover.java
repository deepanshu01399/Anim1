package com.deepanshu.anim1.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.deepanshu.anim1.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;

public class ImageSLiderMover extends AppCompatActivity implements View.OnClickListener {
    private SeekBar imgBlurSlider;
    private KenBurnsView alluArjunImageKBV;
    private Boolean moving = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_slider_mover);

        imgBlurSlider = findViewById(R.id.imgBlurSlider);
        alluArjunImageKBV = findViewById(R.id.alluArjunImage);
        //used for making diffent speed of moving image
        AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
        RandomTransitionGenerator generator = new RandomTransitionGenerator(2000,interpolator);
        alluArjunImageKBV.setTransitionGenerator(generator);

        alluArjunImageKBV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(moving){
                    alluArjunImageKBV.pause();
                    moving = false;
                }else{
                    alluArjunImageKBV.resume();
                    moving = true;
                }
                return true;
            }
        });
        imgBlurSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                alluArjunImageKBV.setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}