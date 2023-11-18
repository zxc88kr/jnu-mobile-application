package com.example.ex05;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioButton rbObj1, rbObj2, rbObj3;
    ImageView ivObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbObj1 = findViewById(R.id.radioButton1);
        rbObj2 = findViewById(R.id.radioButton2);
        rbObj3 = findViewById(R.id.radioButton3);
        ivObj = findViewById(R.id.imageview);

        rbObj1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ivObj.setImageResource(R.drawable.baby);
                    Toast.makeText(getApplicationContext(), "baby selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rbObj2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ivObj.setImageResource(R.drawable.mom);
                    Toast.makeText(getApplicationContext(), "mom selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rbObj3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ivObj.setImageResource(R.drawable.papa);
                    Toast.makeText(getApplicationContext(), "papa selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}