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
    ImageView bookImage;
    TextView bookId, bookName, bookPrice, bookDate,
            bookWriter, bookPage, bookDescription, bookCategory;

    TextView cartCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookImage = findViewById(R.id.bookImage);
        bookId = findViewById(R.id.bookId);
        bookName = findViewById(R.id.bookName);
        bookPrice = findViewById(R.id.bookPrice);
        bookDate = findViewById(R.id.bookDate);
        bookWriter = findViewById(R.id.bookWriter);
        bookPage = findViewById(R.id.bookPage);
        bookDescription = findViewById(R.id.bookDescription);
        bookCategory = findViewById(R.id.bookCategory);

        Intent intent = getIntent();
        bookId.setText(intent.getStringExtra("id"));
        bookName.setText(intent.getStringExtra("name"));
        bookPrice.setText(intent.getStringExtra("price"));
        bookDate.setText(intent.getStringExtra("date"));
        bookWriter.setText(intent.getStringExtra("writer"));
        bookPage.setText(intent.getStringExtra("page"));
        bookDescription.setText(intent.getStringExtra("description"));
        bookCategory.setText(intent.getStringExtra("category"));

        switch (bookId.getText().toString()) {
            case "BOOK1234":
                bookImage.setImageResource(R.drawable.book11);
                break;
            case "BOOK1235":
                bookImage.setImageResource(R.drawable.book21);
                break;
            case "BOOK1236":
                bookImage.setImageResource(R.drawable.book31);
                break;
            case "BOOK1237":
                bookImage.setImageResource(R.drawable.book41);
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
                Book item = new Book();

                item.id = bookId.getText().toString();
                item.name = bookName.getText().toString();
                item.price = Integer.parseInt(bookPrice.getText().toString());
                item.date = bookDate.getText().toString();
                item.writer = bookWriter.getText().toString();
                item.page =  bookPage.getText().toString();
                item.description = bookDescription.getText().toString();
                item.category = bookCategory.getText().toString();
                item.quantity = 0;
                item.isChecked = true;
                cartRepositoryObj.addItem(item);

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