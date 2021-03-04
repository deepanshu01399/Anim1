package com.deepanshu.anim1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.deepanshu.anim1.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBottomSheet, btn_bottom_sheet_dialog, btn_bottom_sheet_dialog_fragment;//,btnCollapse;
    private LinearLayout bottom_sheeet;
    private TextView txt_bottom_sheet_dialog;
    BottomSheetBehavior sheetBehavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_activity);

        bottom_sheeet = findViewById(R.id.bottom_sheeet);
        btnBottomSheet = findViewById(R.id.btn_bottom_sheet);
        btn_bottom_sheet_dialog = findViewById(R.id.btn_bottom_sheet_dialog);
        txt_bottom_sheet_dialog = findViewById(R.id.txt_bottom_sheet_dialog);

        btn_bottom_sheet_dialog_fragment = findViewById(R.id.btn_bottom_sheet_dialog_fragment);

        btnBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleBottomSheet();
            }
        });

        btn_bottom_sheet_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = getLayoutInflater().inflate(R.layout.persistent_bottom_sheet, null);
                BottomSheetDialog dialog = new BottomSheetDialog(BottomSheetActivity.this);
                Button btnTextAnimation1 = view1.findViewById(R.id.btnProcedPayment);
                TextView totalBill = view1.findViewById(R.id.txttotalBill);
                totalBill.setText(getBottomDialogTxt());
                btnTextAnimation1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"btn pressed",Toast.LENGTH_LONG).show();
                        //totalBill.setText(Integer.parseInt(totalBill.getText().toString())+1);
                        txt_bottom_sheet_dialog.setText(Integer.parseInt(totalBill.getText().toString())+1);

                    }
                });
                dialog.setContentView(view1);
                dialog.show();

            }
        });

        btn_bottom_sheet_dialog_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sheetBehavior = BottomSheetBehavior.from(bottom_sheeet);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        btnBottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        btnBottomSheet.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            btnBottomSheet.setText("Close sheet");
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            btnBottomSheet.setText("Expand sheet");
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
          }
    }

     private String getBottomDialogTxt(){
        return txt_bottom_sheet_dialog.getText().toString();
    }
}