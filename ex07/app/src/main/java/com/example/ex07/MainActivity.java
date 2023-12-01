package com.example.ex07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu sub = menu.addSubMenu("편집하기");
        sub.add(Menu.NONE, Menu.FIRST + 0, Menu.NONE, "복사하기");
        sub.add(Menu.NONE, Menu.FIRST + 10, Menu.NONE, "잘라내기");
        sub.add(Menu.NONE, Menu.FIRST + 20, Menu.NONE, "붙여넣기");

        menu.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "검색하기");
        menu.add(Menu.NONE, Menu.FIRST + 2, Menu.NONE, "저장하기");

        return super.onCreateOptionsMenu(menu);
    }
}