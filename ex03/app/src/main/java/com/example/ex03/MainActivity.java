package com.example.ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvObj1;
    TextView tvObj2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Button myButton = new Button(this);

        myButton.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        myButton.setText("버튼");

        Button myButton2 = (Button) findViewById(R.id.button1);
        */

        /*
        TextView textView;

        textView = (TextView) findViewById(R.id.textViewId);
        textView.setText("Android App 배우기");
        textView.setTextColor(Color.parseColor("#03a9f4"));
        textView.setTextSize(50f);
        textView.setTypeface(Typeface.SERIF);
        */

        tvObj1 = findViewById(R.id.num1);
        tvObj2 = findViewById(R.id.num2);
    }

    /*
    public void onButtonClick(View view) {
        Toast.makeText(getApplicationContext(), "눌렀습니다", Toast.LENGTH_SHORT).show();
    }
    */

    public void onClickSum(View view) {
        String value1 = tvObj1.getText().toString();
        String value2 = tvObj2.getText().toString();
        int a = Integer.parseInt(value1);
        int b = Integer.parseInt(value2);
        int sum = a + b;
        Toast.makeText(getApplicationContext(), String.valueOf(sum), Toast.LENGTH_LONG).show();
    }
}