package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView coverBtn1, coverBtn2;
    ImageButton menuBtn1, menuBtn2, menuBtn3, menuBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coverBtn1 = findViewById(R.id.coverBtn1);
        coverBtn2 = findViewById(R.id.coverBtn2);

        menuBtn1 = findViewById(R.id.menuBtn1);
        menuBtn2 = findViewById(R.id.menuBtn2);
        menuBtn3 = findViewById(R.id.menuBtn3);
        menuBtn4 = findViewById(R.id.menuBtn4);

        getSupportActionBar().hide();
    }

    public void onClickCover(View view) {
        if (coverBtn1.getVisibility() == View.VISIBLE) {
            coverBtn2.setVisibility(View.VISIBLE);
            coverBtn1.setVisibility(View.INVISIBLE);
        } else if (coverBtn2.getVisibility() == View.VISIBLE) {
            coverBtn1.setVisibility(View.VISIBLE);
            coverBtn2.setVisibility(View.INVISIBLE);
        }
    }

    public void onClickMenu(View view) {
        if (view.getId() == menuBtn1.getId()) {
            Toast.makeText(this, "도서목록 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, BooksActivity.class);
            startActivity(intent);
        } else if (view.getId() == menuBtn2.getId()) {
            Toast.makeText(this, "동영상강좌 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == menuBtn3.getId()) {
            Toast.makeText(this, "고객센터 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == menuBtn4.getId()) {
            Toast.makeText(this, "마이페이지 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
        }
    }
}