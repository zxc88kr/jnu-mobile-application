package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
        System.out.println(textView.getText());
        textView.setText("1345151dadaf");
        textView.setTextColor(Color.parseColor("#ff0000"));
        textView.setGravity(Gravity.LEFT);
        textView.setTextSize(20);
        textView.setTypeface(Typeface.SERIF);
        textView.setTypeface(Typeface.MONOSPACE);
    }
}