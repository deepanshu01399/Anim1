package com.deepanshu.anim1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.transition.Fade;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private TextView animatedTxt;
    private Button animatedBtn, openNextActivity, leftRightAnim,stateOnOFfBtn,revealBtn,resetBtn;
    private Switch enableDisableBtn;
    private ImageButton switchBtn;
    private Boolean isSwitchBtnPress = true;
    private TextSwitcher leftrightTxtSwitcher;
    private ImageView alluArjunImage,verctorImageAnim;
    private int index = 0;
    private TextView textview;
    private FadingTextView fadingtext;
    private String[] row = {"ONE", "TWO", "THREE", "FOUR", "FIVE"};
    private int i =2;
    private AnimationDrawable animationDrawable;
    private FloatingActionButton floatingBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if we not want to animinate the blink effect on the header
        Fade fade  = new Fade();
        View  decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

       // patch9 images are used to make the icons/images are of same size or in same ration either the text/content area increase..

        initialisation();
        setClicklistner();

        leftrightTxtSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textview = new TextView(MainActivity.this);
                textview.setTextColor(Color.BLACK);
                textview.setTextSize(30);
                textview.setGravity(Gravity.CENTER_HORIZONTAL);
                return textview;
            }
        });
        leftrightTxtSwitcher.setText(row[index]);
       // fadingtext.setTexts(row);
       // fadingtext.setTimeout(300, FadingTextView.MILLISECONDS);
    }

    private void initialisation() {
        animatedTxt = findViewById(R.id.animatedTxt);
        animatedBtn = findViewById(R.id.animatedBtn);
        openNextActivity = findViewById(R.id.openNextActivity);
        leftrightTxtSwitcher = findViewById(R.id.leftrightTxtSwitcher);
        alluArjunImage = findViewById(R.id.alluArjunImage);
       // fadingtext = findViewById(R.id.fadingtext);
        leftRightAnim = findViewById(R.id.leftRightAnim);
        stateOnOFfBtn = findViewById(R.id.stateOnOFfBtn);
        switchBtn = findViewById(R.id.switchBtn);
        enableDisableBtn = findViewById(R.id.enableDisableBtn);
        verctorImageAnim = findViewById(R.id.verctorImageAnim);
        verctorImageAnim.setBackgroundResource(R.drawable.animation);
        animationDrawable = (AnimationDrawable) verctorImageAnim.getBackground();//her upto this animationdrawale in not attach to windo
        revealBtn = findViewById(R.id.revealBtn);
        resetBtn = findViewById(R.id.resetBtn);
        floatingBtn = findViewById(R.id.floatingBtn);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        animationDrawable.start();
    }

    private void setClicklistner() {
        animatedBtn.setOnClickListener(this);
        openNextActivity.setOnClickListener(this);
        leftRightAnim.setOnClickListener(this);
        stateOnOFfBtn.setOnClickListener(this);
        enableDisableBtn.setOnCheckedChangeListener(this);
        switchBtn.setOnClickListener(this);
        revealBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.animatedBtn:
                YoYo.with(Techniques.BounceIn).duration(500).repeat(1).playOn(animatedTxt);
                break;
            case R.id.openNextActivity:
                Intent intent = new Intent(this, SecondActivity.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,alluArjunImage, ViewCompat.getTransitionName(alluArjunImage));
                startActivity(intent,activityOptionsCompat.toBundle());
            // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

            case R.id.leftRightAnim:
                if (index == row.length - 1) {
                    index = 0;
                    leftrightTxtSwitcher.setText(row[index]);
                } else {
                    leftrightTxtSwitcher.setText(row[++index]);
                }
                break;
            case R.id.stateOnOFfBtn:
                i= i+1;
                if(i%2!=0)
                stateOnOFfBtn.setText("ON");
                else
                    stateOnOFfBtn.setText("OFF");
                break;
            case R.id.switchBtn:
                if(isSwitchBtnPress){
                    switchBtn.setSelected(true);//used to maintain selected any button
                    //switchBtn.setPressed(true);
                    //switchBtn.setFocusable(true);
                    isSwitchBtnPress = false;
                }else {
                    //switchBtn.setPressed(false);
                    switchBtn.setSelected(false);
                    //switchBtn.setFocusable(false);
                    isSwitchBtnPress = true;
                }
                break;
            case R.id.revealBtn:
                revealMethod();
                break;
            case R.id.resetBtn:
                resetMethod();
                break;
        }
    }

    private void resetMethod() {
        View view = findViewById(R.id.floatingBtn);
        int width= view.getWidth() / 2;
        int height = view.getHeight() / 2;
        float initalRadius = (float) Math.hypot(width,height);
        Animator animator = ViewAnimationUtils.createCircularReveal(view,width,height,initalRadius,0);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);

            }
        });
        animator.start();

    }

    private void revealMethod() {
        View view = findViewById(R.id.floatingBtn);
        int width= view.getWidth() / 2;
        int height = view.getHeight() / 2;
        float finalRadius = (float) Math.hypot(width,height);
        Animator animator = ViewAnimationUtils.createCircularReveal(view,width,height,0,finalRadius);
        view.setVisibility(View.VISIBLE);
        animator.start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(isChecked){
            switchBtn.setEnabled(true);
        }
        else{
            switchBtn.setEnabled(false);
            switchBtn.setSelected(false);
        }
    }
}