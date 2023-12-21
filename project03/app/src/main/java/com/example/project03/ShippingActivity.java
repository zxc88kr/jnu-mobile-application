package com.example.project03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ShippingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        System.out.println("test");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}