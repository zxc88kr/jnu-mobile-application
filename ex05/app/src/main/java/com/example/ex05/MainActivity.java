package com.example.ex05;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Switch sbObj1, sbObj2, sbObj3;
    TextView tvObj;
    String result = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbObj1 = findViewById(R.id.switch1);
        sbObj2 = findViewById(R.id.switch2);
        sbObj3 = findViewById(R.id.switch3);
        tvObj = findViewById(R.id.textView);

        sbObj1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    tvObj.setVisibility(View.INVISIBLE);
                else
                    tvObj.setVisibility(View.VISIBLE);
            }
        });

        sbObj2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    tvObj.setTypeface(null, Typeface.BOLD);
                else
                    tvObj.setTypeface(null, Typeface.NORMAL);
            }
        });

        sbObj3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    tvObj.setTextColor(Color.RED);
                else
                    tvObj.setTextColor(Color.BLACK);
            }
        });
    }
}