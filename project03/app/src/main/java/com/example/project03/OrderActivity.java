package com.example.project03;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}