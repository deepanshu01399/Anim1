package com.deepanshu.anim1.activity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.deepanshu.anim1.R;

public class RatedAnimActivity extends AppCompatActivity {

    Animation imageanim, nothingToDoAnim, nothingToDoBtnAnim;
    private ImageView imageview1;
    private TextView txtratingMsg;
    private Button btnSubmitRating;
    private RatingBar txtRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rated_anim_activity);

        initView();
        setOnCLickLisnter();
    }

    private void initView() {
        imageanim = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        nothingToDoAnim = AnimationUtils.loadAnimation(this, R.anim.notingtocome);
        nothingToDoBtnAnim = AnimationUtils.loadAnimation(this, R.anim.sprit_barish);

        imageview1 = findViewById(R.id.image1);
        txtRating = findViewById(R.id.txtRating);
        txtratingMsg = findViewById(R.id.txtRatingMsg);
        btnSubmitRating = findViewById(R.id.btnSubmitRating);

        imageview1.startAnimation(imageanim);
        txtratingMsg.startAnimation(nothingToDoAnim);
        btnSubmitRating.setAnimation(nothingToDoBtnAnim);


    }

    private void setOnCLickLisnter() {
        txtRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                String ratingValue = String.valueOf((int) (ratingBar.getRating()));
                if (ratingValue.equalsIgnoreCase("1")) {
                    //Toast.makeText(RatedAnimActivity.this, "1", Toast.LENGTH_SHORT).show();
                    imageview1.setImageResource(R.drawable.custom_like_icon);
                    txtratingMsg.setText("Just so so");
                    imageview1.startAnimation(imageanim);
                    txtratingMsg.startAnimation(nothingToDoAnim);


                }
                if (ratingValue.equalsIgnoreCase("2")) {
                    //Toast.makeText(RatedAnimActivity.this, "2", Toast.LENGTH_SHORT).show();
                    imageview1.setImageResource(R.drawable.allu);
                    txtratingMsg.setText("Aeah not so impresive...");
                    imageview1.startAnimation(imageanim);
                    txtratingMsg.startAnimation(nothingToDoAnim);


                }
                if (ratingValue.equalsIgnoreCase("3")) {
                    //Toast.makeText(RatedAnimActivity.this, "3", Toast.LENGTH_SHORT).show();
                    imageview1.setImageResource(R.drawable.congrats);
                    txtratingMsg.setText("Thanks buddy...");
                    imageview1.startAnimation(imageanim);
                    txtratingMsg.startAnimation(nothingToDoAnim);


                }
                if (ratingValue.equalsIgnoreCase("4")) {
                    //Toast.makeText(RatedAnimActivity.this, "4", Toast.LENGTH_SHORT).show();
                    imageview1.setImageResource(R.drawable.congrats1);
                    txtratingMsg.setText("bete aa bete...");
                    imageview1.startAnimation(imageanim);
                    txtratingMsg.startAnimation(nothingToDoAnim);


                }
                if (ratingValue.equalsIgnoreCase("5")) {
                    //Toast.makeText(RatedAnimActivity.this, "5", Toast.LENGTH_SHORT).show();
                    imageview1.setImageResource(R.drawable.congrats2);
                    txtratingMsg.setText("Mouj hi kar dii...");
                    imageview1.startAnimation(imageanim);
                    txtratingMsg.startAnimation(nothingToDoAnim);


                }
            }
        });

    }
}