package com.example.ex06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    Button btnObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView idObj= findViewById(R.id.textView01);
        TextView pwObj  = findViewById(R.id.textView02);
        Intent intent = getIntent();
        idObj.setText(intent.getStringExtra("userId"));
        pwObj.setText(intent.getStringExtra("userPw"));
    }
}