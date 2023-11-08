package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.imageBtn1);
        btn2 = findViewById(R.id.imageBtn2);
        btn3 = findViewById(R.id.imageBtn3);
        btn4 = findViewById(R.id.imageBtn4);
    }

    public void onClickMenu(View view) {
        if (view.getId() == btn1.getId()) {
            Toast.makeText(getApplicationContext(), "도서목록 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == btn2.getId()) {
            Toast.makeText(getApplicationContext(), "동영상강좌 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == btn3.getId()) {
            Toast.makeText(getApplicationContext(), "고객센터 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == btn4.getId()) {
            Toast.makeText(getApplicationContext(), "마이페이지 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
        }
    }
}