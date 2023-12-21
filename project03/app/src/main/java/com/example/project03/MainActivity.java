package com.example.project03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project03.model.CartRepository;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView cover1, cover2;

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigation;

    public static CartRepository cartRepositoryObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cover1 = findViewById(R.id.cover1);
        cover2 = findViewById(R.id.cover2);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigation = findViewById(R.id.navigation);

        cartRepositoryObj = new CartRepository();

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        navigation.setNavigationItemSelectedListener(this);
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
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.menuBtn1:
                intent = new Intent(this, BooksActivity.class);
                startActivity(intent);
                break;
            case R.id.menuBtn2:
            case R.id.menuBtn3:
            case R.id.menuBtn4:
                break;
        }
        Toast.makeText(this, view.getTag().toString() + " 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int index = 0;
        switch (item.getItemId()) {
            case R.id.menuLogin:
                index = 1;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_login, null);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.show();

                Button loginBtn = dialogView.findViewById(R.id.loginBtn);
                loginBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView textViewID = dialogView.findViewById(R.id.userID);
                        TextView textViewPW = dialogView.findViewById(R.id.userPW);

                        alertDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "아이디: " + textViewID.getText() + ", 비밀번호: " + textViewPW.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.menuSetting:
                index = 2;
                break;
            case R.id.menuMyinfo:
                index = 3;
                break;
        }
        drawerLayout.closeDrawers();
        Toast.makeText(this, "메뉴" + index + ": " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}