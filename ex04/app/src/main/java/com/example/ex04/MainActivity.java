package com.example.ex04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnObj;
    ImageView imgObj1, imgObj2;
    Integer num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgObj1 = findViewById(R.id.img01);
        imgObj2 = findViewById(R.id.img02);

        btnObj = findViewById(R.id.btn);
        btnObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == 0) {
                    imgObj1.setVisibility(View.INVISIBLE);
                    imgObj2.setVisibility(View.VISIBLE);
                    num = 1;
                } else if (num == 1) {
                    imgObj1.setVisibility(View.VISIBLE);
                    imgObj2.setVisibility(View.INVISIBLE);
                    num = 0;
                }
            }
        });
    }
}