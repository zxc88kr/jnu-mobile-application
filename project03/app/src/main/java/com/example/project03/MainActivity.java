package com.example.project03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView cover1, cover2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cover1 = findViewById(R.id.cover1);
        cover2 = findViewById(R.id.cover2);

        getSupportActionBar().hide();
    }

    public void onClickCover(View view) {
        if (cover1.getVisibility() == View.VISIBLE) {
            cover2.setVisibility(View.VISIBLE);
            cover1.setVisibility(View.INVISIBLE);
        } else if (cover2.getVisibility() == View.VISIBLE) {
            cover1.setVisibility(View.VISIBLE);
            cover2.setVisibility(View.INVISIBLE);
        }
    }

    public void onClickMenu(View view) {
        switch (view.getId()) {
            case R.id.menuBtn1:
                Toast.makeText(this, "도서목록 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, BooksActivity.class);
                startActivity(intent);
                break;
            case R.id.menuBtn2:
                Toast.makeText(this, "동영상강좌 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuBtn3:
                Toast.makeText(this, "고객센터 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuBtn4:
                Toast.makeText(this, "마이페이지 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}