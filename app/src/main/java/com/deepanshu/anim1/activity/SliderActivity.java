package com.deepanshu.anim1.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.deepanshu.anim1.R;
import com.google.android.material.slider.Slider;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class SliderActivity extends AppCompatActivity implements View.OnClickListener {
    private Button lockedBtn,unlockedBtn;
    private SlidrInterface  slidrInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        setTitle(getResources().getString(R.string.slider_activity));

        lockedBtn = findViewById(R.id.lockedBtn);
        unlockedBtn = findViewById(R.id.unlockBtn);
        lockedBtn.setOnClickListener(this);
        unlockedBtn.setOnClickListener(this);
        slidrInterface = Slidr.attach(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.unlockBtn:
                slidrInterface.unlock();

                break;
            case R.id.lockedBtn:
                slidrInterface.lock();
                break;
        }
    }
}