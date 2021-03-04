package com.deepanshu.anim1.activity;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import com.deepanshu.anim1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR;


public class ImageHolderAnimActvity extends AppCompatActivity implements View.OnClickListener {

    private Placeholder placeHolderButton,placeHOlderImage1;
    private ConstraintLayout constraiantLayout;
    private ImageView image1;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageholder_activity);
        initView();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Transition changeBounds = new ChangeBounds();
                changeBounds.setInterpolator(new OvershootInterpolator());//AnticipateInterpolator :some zomming effect ke sath..
                TransitionManager.beginDelayedTransition(constraiantLayout,changeBounds);
                placeHOlderImage1.setContentId(R.id.image1);
                placeHolderButton.setContentId(R.id.floatingBtn);
                //setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);

            }
        });

    }

    private void initView() {
        image1 = findViewById(R.id.image1);
        floatingActionButton  =findViewById(R.id.floatingBtn);
        placeHOlderImage1 = findViewById(R.id.placeHOlderImage1);
        placeHolderButton = findViewById(R.id.placeHolderButton);
        constraiantLayout = findViewById(R.id.constraiantLayout);

    }

     @Override
    public void onClick(View view) {
        switch (view.getId()) {


        }
    }


}