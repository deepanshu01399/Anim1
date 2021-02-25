package com.deepanshu.anim1.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.deepanshu.anim1.R;
import com.deepanshu.anim1.activity.BasicAnim;
import com.deepanshu.anim1.activity.ImageSLiderMover;
import com.deepanshu.anim1.activity.SliderActivity;
import com.deepanshu.anim1.activity.ViewFlipper;

public class SimpleFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private Button btnFragment;
    private EditText editTextFrag;
    private static SendBackDataToActivity sendBackDataToActivity;

    // TODO: Rename and change types of parameters
    private String mParam1;

    public static SimpleFragment newInstance(String text) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, text);
        fragment.setArguments(args);
        return fragment;
    }

    public SimpleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        btnFragment = view.findViewById(R.id.btnFragment);
        editTextFrag = view.findViewById(R.id.editTextFrag);
        editTextFrag.setText(mParam1);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edittext = getEditText();
                if (sendBackDataToActivity != null)
                    sendBackDataToActivity.sendBackData(edittext);

            }
        });
        return view;

    }

    private String getEditText() {
        return editTextFrag.getText().toString();
    }

    public interface SendBackDataToActivity {
        void sendBackData(String data);

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SendBackDataToActivity) {
            sendBackDataToActivity = (SendBackDataToActivity) context;
        }
    }
}