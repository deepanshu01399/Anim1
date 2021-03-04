package com.deepanshu.anim1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.deepanshu.anim1.R;

public class GetStartedAnim extends AppCompatActivity {

    Animation imageanim,nothingToDoAnim,nothingToDoBtnAnim;
    private ImageView imageview1;
    private TextView shopText, shopTextDesc;
    private Button nothingToDoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_started_anim_activity);

        initView();
        setOnCLickLisnter();
    }

    private void initView() {
        imageanim = AnimationUtils.loadAnimation(this,R.anim.smalltobig);
        nothingToDoAnim = AnimationUtils.loadAnimation(this,R.anim.notingtocome);
        nothingToDoBtnAnim = AnimationUtils.loadAnimation(this,R.anim.notingtocomebtn);

        imageview1 = findViewById(R.id.image1);
        imageview1.startAnimation(imageanim);
        shopText = findViewById(R.id.txtshopday);
        shopTextDesc = findViewById(R.id.txtshopDayMsg);
        nothingToDoBtn = findViewById(R.id.btnOpenNextactivity);
        shopText.startAnimation(nothingToDoAnim);
        shopTextDesc.setAnimation(nothingToDoAnim);
        nothingToDoBtn.setAnimation(nothingToDoBtnAnim);



    }
    private void setOnCLickLisnter() {

    }
}