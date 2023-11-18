package com.example.ex05;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ToggleButton tbObj1, tbObj2;
    ImageView ivObj1, ivObj2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbObj1 = (ToggleButton) findViewById(R.id.toggleButton1);
        tbObj2 = findViewById(R.id.toggleButton2);
        ivObj1 = findViewById(R.id.imageView);
        ivObj2 = findViewById(R.id.imageView2);

        tbObj1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tbObj1.setBackgroundResource(R.drawable.togglebutton_off);
                    ivObj1.setImageResource(R.drawable.light_turn_on);
                } else {
                    tbObj1.setBackgroundResource(R.drawable.togglebutton_on);
                    ivObj1.setImageResource(R.drawable.light_turn_off);
                }
            }
        });

        tbObj2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tbObj2.setBackgroundResource(R.drawable.togglebutton_off);
                    ivObj2.setImageResource(R.drawable.light2_turn_on);
                } else {
                    tbObj2.setBackgroundResource(R.drawable.togglebutton_on);
                    ivObj2.setImageResource(R.drawable.light2_turn_off);
                }
            }
        });
    }
}