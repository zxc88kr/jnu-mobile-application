package com.example.ex06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnObj = findViewById(R.id.button);
        btnObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                EditText editText01 = findViewById(R.id.editText01);
                EditText editText02 = findViewById(R.id.editText02);
                intent.putExtra("userId", editText01.getText().toString());
                intent.putExtra("userPw", editText02.getText().toString());
                startActivity(intent);
            }
        });
    }
}