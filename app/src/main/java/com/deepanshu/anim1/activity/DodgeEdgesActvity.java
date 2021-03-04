package com.deepanshu.anim1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.deepanshu.anim1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class DodgeEdgesActvity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOpenGame;
    private FloatingActionButton floatingActionButton;
    private LinearLayout gameLL;
    private ImageView spinImage;
    private Boolean wantsToPlay = true;
    private Random random = new Random();
    private int lastDirection ;
    private Boolean isSpinning = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodge_edges_activity);
        initView();
        setClickLisnter();

    }

    private void initView() {
        floatingActionButton = findViewById(R.id.floatingBtn);
        btnOpenGame = findViewById(R.id.btnOpenGame);
        gameLL = findViewById(R.id.gameLL);
        gameLL.setVisibility(View.GONE);
        spinImage = findViewById(R.id.spinImage);
    }

    private void setClickLisnter() {
        floatingActionButton.setOnClickListener(this);
        btnOpenGame.setOnClickListener(this);
        spinImage.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.floatingBtn:
                Snackbar.make(view, "Clicked on BottomSheetActivity ", Snackbar.LENGTH_LONG).show();
                break;

            case R.id.btnOpenGame:
                if(wantsToPlay) {
                    gameLL.setVisibility(View.VISIBLE);
                    wantsToPlay = false;
                    btnOpenGame.setText("Close Game");
                }
                else{
                    gameLL.setVisibility(View.GONE);
                    wantsToPlay = true;
                    btnOpenGame.setText("Play Game");
                }
                break;

            case R.id.spinImage:
                spinningBottle(view);
                break;


        }
    }

    public  void spinningBottle(View view){
        if(!isSpinning) {
            int randomNo = random.nextInt(4800); //1800/360 = 5 times round
            float pivotX = spinImage.getWidth() / 2;//it return the width middle
            float pivotY = spinImage.getHeight() / 2;//return the height middle..
            Animation rotateAnimation = new RotateAnimation(lastDirection, randomNo, pivotX, pivotY);
            rotateAnimation.setDuration(2500);//2.5 second ke ander 5 rotation lagegi bottle
            rotateAnimation.setFillAfter(true);//as it as direction mai hi rakhna ... spinn image ko
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    isSpinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    isSpinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            lastDirection = randomNo;
            spinImage.startAnimation(rotateAnimation);

        }
    }


}