package com.deepanshu.anim1.activity;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import com.deepanshu.anim1.R;
import com.google.android.material.snackbar.Snackbar;


public class PlaceHolderAnimActvity extends AppCompatActivity implements View.OnClickListener {

    private Placeholder placeHolder;
    private ConstraintLayout constraiantLayout;
    private ImageView image1,image2,image3,image4,image5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placeholder_activity);
        initView();
        setClickLisnter();

    }

    private void initView() {
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        placeHolder = findViewById(R.id.placeHolder);
        constraiantLayout = findViewById(R.id.constraiantLayout);

    }

    private void setClickLisnter() {
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);



    }

    public void swapView (View view){
        TransitionManager.beginDelayedTransition(constraiantLayout);
        placeHolder.setContentId(view.getId());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image1:
            case R.id.image2:
            case R.id.image3:
            case R.id.image4:
            case R.id.image5:
            swapView(view);
                break;


        }
    }


}