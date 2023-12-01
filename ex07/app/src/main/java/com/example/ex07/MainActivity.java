package com.example.ex07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    TextView text;
    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.background);
        text = (TextView) findViewById(R.id.text);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu01:
                text.setTextColor(Color.parseColor("#ffff00"));
                break;
            case R.id.menu02:
                text.setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.menu03:
                layout.setBackgroundColor(Color.parseColor("#ff0000"));
                break;
            case R.id.menu04:
                layout.setBackgroundColor(Color.parseColor("#00ff00"));
                break;
            case R.id.menu05:
                layout.setBackgroundColor(Color.parseColor("#0000ff"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}