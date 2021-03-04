package com.deepanshu.anim1.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.deepanshu.anim1.R;

public class ViewFlipper extends AppCompatActivity implements View.OnClickListener {
    private android.widget.ViewFlipper viewFlipper ;
    private Button nextView,previousView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_flipper);
        viewFlipper = findViewById(R.id.viewFlipper);
        nextView = findViewById(R.id.nextView);
        previousView = findViewById(R.id.prevView);
//        TextView textView = new TextView(this);
//        textView.setText("Previous text addedd");
//        textView.setGravity(Gravity.CENTER);
//        viewFlipper.addView(textView);
        nextView.setOnClickListener(this);
        previousView.setOnClickListener(this);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();
        //viewFlipper.stopFlipping();//for stoping the flippinng

    }
    public void nextView(View v){
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);
        viewFlipper.showNext();

    }

    public void previouView(View v){
        viewFlipper.setInAnimation(this,R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_right);
        viewFlipper.showPrevious();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nextView:
                previouView(view);
                break;
            case R.id.prevView:
                nextView(view);
                break;
        }
    }
}