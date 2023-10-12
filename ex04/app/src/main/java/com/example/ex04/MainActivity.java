package com.example.ex04;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.HORIZONTAL);
        myLayout.setBackgroundColor(Color.rgb(0, 255, 0));

        Button b1 = new Button(this);
        b1.setText("버튼1");
        myLayout.addView(b1);

        setContentView(myLayout, params);
    }
}