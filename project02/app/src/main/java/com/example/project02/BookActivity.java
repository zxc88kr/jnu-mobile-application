package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {
    ImageView details0;
    TextView details1, details2, details3, details4,
            details5, details6, details7, details8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        details0 = findViewById(R.id.details0);
        details1 = findViewById(R.id.details1);
        details2 = findViewById(R.id.details2);
        details3 = findViewById(R.id.details3);
        details4 = findViewById(R.id.details4);
        details5 = findViewById(R.id.details5);
        details6 = findViewById(R.id.details6);
        details7 = findViewById(R.id.details7);
        details8 = findViewById(R.id.details8);

        Intent intent = getIntent();
        details1.setText(intent.getStringExtra("id"));
        details2.setText(intent.getStringExtra("name"));
        details3.setText(intent.getStringExtra("price"));
        details4.setText(intent.getStringExtra("date"));
        details5.setText(intent.getStringExtra("writer"));
        details6.setText(intent.getStringExtra("page"));
        details7.setText(intent.getStringExtra("description"));
        details8.setText(intent.getStringExtra("category"));

        switch (details1.getText().toString()) {
            case "BOOK1234":
                details0.setImageResource(R.drawable.book11);
                break;
            case "BOOK1235":
                details0.setImageResource(R.drawable.book21);
                break;
            case "BOOK1236":
                details0.setImageResource(R.drawable.book31);
                break;
            case "BOOK1237":
                details0.setImageResource(R.drawable.book41);
                break;
        }

        getSupportActionBar().hide();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}