package com.example.ex07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), btn);
                popup.inflate(R.menu.menu);
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu01:
                                Toast.makeText(getApplicationContext(), "메뉴1: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu02:
                                Toast.makeText(getApplicationContext(), "메뉴2: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu03:
                                Toast.makeText(getApplicationContext(), "메뉴3: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
            }
        });
    }
}