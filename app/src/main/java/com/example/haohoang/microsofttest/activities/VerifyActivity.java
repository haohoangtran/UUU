package com.example.haohoang.microsofttest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.haohoang.microsofttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerifyActivity extends AppCompatActivity {
    @BindView(R.id.bt_from_gallery)
    Button bt_from_gallery;
    @BindView(R.id.bt_from_capture)
    Button btFromCapture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        ButterKnife.bind(this);
    }

}
