package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        Integer a = Integer.parseInt(textView.getText().toString());
        System.out.println(a);
        textView.setText("1345151dadaf");
        textView.setTextColor(Color.parseColor("#ff0000"));
        textView.setGravity(Gravity.LEFT);
        textView.setTextSize(20);
        textView.setTypeface(Typeface.SERIF);
        textView.setTypeface(Typeface.MONOSPACE);

        editText = (EditText) findViewById(R.id.editText);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.menu02);
    }

    public void onButtonClick1(View view) {
        Toast.makeText(getApplicationContext(), String.valueOf(3), Toast.LENGTH_LONG).show();
    }

    public void onButtonClick2(View view) {
        Toast.makeText(getApplicationContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}