package com.deepanshu.anim1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.deepanshu.anim1.R;
import com.deepanshu.anim1.fragment.SimpleFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SimpleFragment.SendBackDataToActivity {
    private Button btnOpenBasicAcitvity, btnImageSLiderAcitvity, btnOpenViewFlipperAcitvity, btnSliderAcitvity, btnActivityFragment;
    private EditText editTextActivityFrag;
    private Intent intent = null;
    private Button btnBottomSheet;


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
        //btnCollapse = findViewById(R.id.btnColapseView);

    }

    private void setClickLisnter() {
        btnOpenBasicAcitvity.setOnClickListener(this);
        btnImageSLiderAcitvity.setOnClickListener(this);
        btnOpenViewFlipperAcitvity.setOnClickListener(this);
        btnImageSLiderAcitvity.setOnClickListener(this);
        btnSliderAcitvity.setOnClickListener(this);
        btnActivityFragment.setOnClickListener(this);
        btnBottomSheet.setOnClickListener(this);
        //btnExpandView.setOnClickListener(this);

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