package com.deepanshu.anim1.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.deepanshu.anim1.R;
import com.like.LikeButton;

public class DoubleClickActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView alluArjunImage;
    private Boolean doubleTap = false;
    private LikeButton heartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doubleclick);
        initView();
        setClickLisnter();

    }

    private void initView() {
        alluArjunImage = findViewById(R.id.alluArjunImage);
        heartButton = findViewById(R.id.heartButton);
        heartButton.setEnabled(false);

    }

    private void setClickLisnter() {
        alluArjunImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alluArjunImage:
               Boolean isDoubleClick =  checkDoubleClickOrNot();
               if(isDoubleClick){
                   heartButton.setEnabled(true);
                  Boolean isheartBtnLiked =  heartButton.isLiked();
                   heartButton.setLiked(!isheartBtnLiked);
                   if(heartButton.isLiked()) {
                       heartButton.setVisibility(View.VISIBLE);
                       new Handler().postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               heartButton.setVisibility(View.GONE);
                           }
                       }, 600);
                   }
                   else{
                       heartButton.setVisibility(View.GONE);
                   }
               }
                break;
        }

    }

    private Boolean checkDoubleClickOrNot() {
        if(doubleTap){
            return true;
        }else{
            doubleTap =true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleTap = false;
                }
            }, 300);
        }
        return false;
    }
}
