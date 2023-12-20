package com.example.project03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {
    ImageView details0;
    TextView details1, details2, details3, details4,
            details5, details6, details7, details8;

    TextView cartCount;
    Integer count = 0; // 수정 필요

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClickAddCart(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(BookActivity.this);
        builder.setTitle("도서주문");
        builder.setMessage("상품을 장바구니에 추가하겠습니까?");
        builder.setIcon(R.drawable.dialog_cat);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        count = Integer.parseInt(cartCount.getText().toString()) + 1; // 수정 필요
                        cartCount.setText(Integer.toString(count));
                        dialog.dismiss();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        dialog.cancel();
                        break;
                }
            }
        };
        builder.setPositiveButton("예", listener);
        builder.setNegativeButton("아니오", listener);
        builder.show();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book, menu);
        MenuItem cartItem = menu.findItem(R.id.menuCart);
        MenuItemCompat.setActionView(cartItem, R.layout.cart_count);
        FrameLayout notifyCount = (FrameLayout) cartItem.getActionView();

        cartCount = (TextView) notifyCount.findViewById(R.id.cartCount);
        cartCount.setText(Integer.toString(count)); // 수정 필요
        ImageView imageView = (ImageView) notifyCount.findViewById(R.id.cartImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BooksActivity.class); // 수정 필요
                startActivity(intent);
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return super.onOptionsItemSelected(item);
            case R.id.menuHome:
                intent = new Intent(this, MainActivity.class);
                break;
            case R.id.menuBook:
                intent = new Intent(this, BooksActivity.class);
                break;
            case R.id.menuCart:
                // 추가 필요
                break;
        }
        startActivity(intent);
        finish();
        Toast.makeText(this, item.getTitle() + " 메뉴가 클릭되었습니다", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}