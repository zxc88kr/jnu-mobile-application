package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (ImageButton) findViewById(R.id.button1);
        btn2 = (ImageButton) findViewById(R.id.button2);
        btn3 = (ImageButton) findViewById(R.id.button3);
    }

    public void onClickChoice(View view) {
        if (view.getId() == btn1.getId()) {
            Toast.makeText(getApplicationContext(), "틀렸습니다", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == btn2.getId()) {
            Toast.makeText(getApplicationContext(), "맞았습니다", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == btn3.getId()) {
            Toast.makeText(getApplicationContext(), "틀렸습니다", Toast.LENGTH_SHORT).show();
        }
    }
}
