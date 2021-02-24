package com.deepanshu.anim1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.Fade;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView animatedTxt;
    private Button animatedBtn, openNextActivity, leftRightAnim,stateOnOFfBtn;
    private TextSwitcher leftrightTxtSwitcher;
    private ImageView alluArjunImage;
    private int index = 0;
    private TextView textview;
    private FadingTextView fadingtext;
    private String[] row = {"ONE", "TWO", "THREE", "FOUR", "FIVE"};
    private int i =2;


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

    }

    private void setClicklistner() {
        animatedBtn.setOnClickListener(this);
        openNextActivity.setOnClickListener(this);
        leftRightAnim.setOnClickListener(this);
        stateOnOFfBtn.setOnClickListener(this);

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
                break;
            // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
    }
}