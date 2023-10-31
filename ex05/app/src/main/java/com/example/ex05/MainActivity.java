package com.example.ex05;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btObj1, btObj2, btObj3;
    ImageView ivObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btObj1 = findViewById(R.id.imageButton1);
        btObj2 = findViewById(R.id.imageButton2);
        btObj3 = findViewById(R.id.imageButton3);
        ivObj  = findViewById(R.id.imageView2);
        btObj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivObj.setVisibility(View.VISIBLE);
                ivObj.setImageResource(R.drawable.anwer1);
                Toast.makeText(getApplicationContext(), "틀렸습니다", Toast.LENGTH_SHORT).show();
            }
        });
        btObj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivObj.setVisibility(View.VISIBLE);
                ivObj.setImageResource(R.drawable.anwer2);
                Toast.makeText(getApplicationContext(), "맞았습니다", Toast.LENGTH_SHORT).show();
            }
        });
        btObj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivObj.setVisibility(View.VISIBLE);
                ivObj.setImageResource(R.drawable.anwer3);
                Toast.makeText(getApplicationContext(), "틀렸습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}