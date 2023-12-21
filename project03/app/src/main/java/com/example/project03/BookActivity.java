package com.example.project03;

import static com.example.project03.MainActivity.cartRepositoryObj;

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

import com.example.project03.model.Book;

public class BookActivity extends AppCompatActivity {
    ImageView details0;
    TextView details1, details2, details3, details4,
            details5, details6, details7, details8;

    TextView cartCount;

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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(BookActivity.this);
        alertDialog.setTitle("도서주문");
        alertDialog.setMessage("상품을 장바구니에 추가하겠습니까?");
        alertDialog.setIcon(R.drawable.dialog_cat);

        alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Book book = new Book();

                book.id = details1.getText().toString();
                book.name = details2.getText().toString();
                book.price = Integer.parseInt(details3.getText().toString());
                book.date = details4.getText().toString();
                book.writer = details5.getText().toString();
                book.page =  details6.getText().toString();
                book.description = details7.getText().toString();
                book.category = details8.getText().toString();
                book.quantity = 0;
                book.isChecked = true;
                cartRepositoryObj.addCart(book);

                int count = Integer.parseInt(cartCount.getText().toString()) + 1;
                cartCount.setText(Integer.toString(count));
                dialog.dismiss();
            }
        });
        alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
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
        cartCount.setText(Integer.toString(cartRepositoryObj.getTotalQuantity()));

        ImageView imageView = (ImageView) notifyCount.findViewById(R.id.cartImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
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
                startActivity(intent);
                finish();
                break;
            case R.id.menuBook:
                intent = new Intent(this, BooksActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.menuCart:
                break;
        }
        Toast.makeText(this, item.getTitle() + " 메뉴가 클릭되었습니다", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (cartCount != null) {
            cartCount.setText(Integer.toString(cartRepositoryObj.getTotalQuantity()));
        }
    }
}