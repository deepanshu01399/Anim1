package com.deepanshu.anim1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.deepanshu.anim1.R;
import com.deepanshu.anim1.fragment.SimpleFragment;
import com.google.android.material.snackbar.Snackbar;
import com.like.LikeButton;
import com.like.OnLikeListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SimpleFragment.SendBackDataToActivity {
    private Button btnOpenBasicAcitvity, btnImageSLiderAcitvity, btnOpenViewFlipperAcitvity, btnSliderAcitvity, btnActivityFragment,btnGetStartedAnim;
    private EditText editTextActivityFrag;
    private Intent intent = null;
    private Button btnBottomSheet,btnModalBottomSheet,btnRatedANim,btnDodgeEdges,btnOpenPlaceholderAnim,btnOpenImageRoatateAnim,btnGestureAnim;
    private LikeButton likeButton;
    private ImageView imageView;
    private static  String TAG = "MainActivity";
    private AnimationDrawable animationDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setClickLisnter();

    }

    private void initView() {
        btnOpenBasicAcitvity = findViewById(R.id.btnOpenBasicAcitvity);
        btnImageSLiderAcitvity = findViewById(R.id.btnImageSLiderAcitvity);
        btnOpenViewFlipperAcitvity = findViewById(R.id.btnOpenViewFlipperAcitvity);
        btnSliderAcitvity = findViewById(R.id.btnSliderAcitvity);
        editTextActivityFrag = findViewById(R.id.editTextActivityFrag);
        btnActivityFragment = findViewById(R.id.btnActivityFragment);
        btnBottomSheet = findViewById(R.id.btnBottomSheet);
        btnModalBottomSheet = findViewById(R.id.btnBottomSheet);
        btnDodgeEdges = findViewById(R.id.btnDodgeEdges);
        btnOpenPlaceholderAnim = findViewById(R.id.btnOpenPlaceholderAnim);
        btnOpenImageRoatateAnim = findViewById(R.id.btnOpenImageRoatateAnim);
        likeButton = findViewById(R.id.likeButton);
        btnGestureAnim = findViewById(R.id.btnGestureAnim);
        imageView = findViewById(R.id.imageView);
        btnGetStartedAnim = findViewById(R.id.btnGetStartedAnim);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        btnRatedANim = findViewById(R.id.btnRatedANim);

    }

    private void setClickLisnter() {
        btnOpenBasicAcitvity.setOnClickListener(this);
        btnImageSLiderAcitvity.setOnClickListener(this);
        btnOpenViewFlipperAcitvity.setOnClickListener(this);
        btnImageSLiderAcitvity.setOnClickListener(this);
        btnSliderAcitvity.setOnClickListener(this);
        btnActivityFragment.setOnClickListener(this);
        btnBottomSheet.setOnClickListener(this);
        btnModalBottomSheet.setOnClickListener(this);
        btnDodgeEdges.setOnClickListener(this);
        btnOpenPlaceholderAnim.setOnClickListener(this);
        btnOpenImageRoatateAnim.setOnClickListener(this);
        btnGestureAnim.setOnClickListener(this);
        imageView.setOnClickListener(this);
        btnGetStartedAnim.setOnClickListener(this);
        btnRatedANim.setOnClickListener(this);
        likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Toast.makeText(MainActivity.this,"Liked",Toast.LENGTH_LONG).show();
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                Toast.makeText(MainActivity.this,"UnLiked",Toast.LENGTH_LONG).show();

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOpenBasicAcitvity:
                intent = new Intent(this, BasicAnim.class);
                startActivity(intent);
                break;

            case R.id.btnImageSLiderAcitvity://kvm dependency vala
                intent = new Intent(this, ImageSLiderMover.class);
                startActivity(intent);
                break;

            case R.id.btnOpenViewFlipperAcitvity://animation ek bar mai ek hi page show hoga...
                intent = new Intent(this, ViewFlipper.class);
                startActivity(intent);
                break;

            case R.id.btnSliderAcitvity://used for go and come back to next-prev activity with fingerSlider
                intent = new Intent(this, SliderActivity.class);
                startActivity(intent);
                break;
            case R.id.btnActivityFragment:
                String edittext = getEditText();
                openFragment(edittext);
                break;
            case R.id.btnBottomSheet:
                intent = new Intent(this, BottomSheetActivity.class);
                startActivity(intent);
                break;
            case R.id.btnDodgeEdges:
                intent = new Intent(this, DodgeEdgesActvity.class);
                startActivity(intent);
                break;
            case R.id.btnOpenPlaceholderAnim:
                intent = new Intent(this, PlaceHolderAnimActvity.class);
                startActivity(intent);
                break;
            case R.id.btnOpenImageRoatateAnim:
                intent = new Intent(this, ImageHolderAnimActvity.class);
                startActivity(intent);
                break;
            case R.id.btnGestureAnim:
                intent = new Intent(this, DoubleClickActivity.class);
                startActivity(intent);
                break;
            case R.id.imageView:
                animationDrawable.start();
                break;
            case R.id.btnGetStartedAnim:
                intent = new Intent(this, GetStartedAnim.class);
                startActivity(intent);

                break;
            case R.id.btnRatedANim:
                intent = new Intent(this, RatedAnimActivity.class);
                startActivity(intent);
                break;


        }
    }

    private void openFragment(String edittext) {
        SimpleFragment simpleFragment = SimpleFragment.newInstance(edittext);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.fragment_container, simpleFragment, "Blank_fragment").commit();
    }

    private String getEditText() {
        return editTextActivityFrag.getText().toString();
    }

    @Override
    public void sendBackData(String data) {
        editTextActivityFrag.setText(data);
        onBackPressed();
    }
}