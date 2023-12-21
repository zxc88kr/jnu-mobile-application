package com.example.project03;

import static com.example.project03.MainActivity.cartRepositoryObj;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project03.adapter.OrderAdapter;

public class OrderActivity extends AppCompatActivity {
    OrderAdapter orderAdapter;

    TextView orderDate, orderName, orderZipCode, orderAddress, orderTotalPrice;
    Button orderSubmitBtn, orderCancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderDate = findViewById(R.id.orderDate);
        orderName = findViewById(R.id.orderName);
        orderZipCode = findViewById(R.id.orderZipCode);
        orderAddress = findViewById(R.id.orderAddress);
        orderTotalPrice = findViewById(R.id.orderTotalPrice);

        orderSubmitBtn = findViewById(R.id.orderSubmitBtn);
        orderCancelBtn = findViewById(R.id.orderCancelBtn);

        Intent intent = getIntent();
        orderDate.setText(intent.getStringExtra("date"));
        orderName.setText(intent.getStringExtra("name") +
                "(" + intent.getStringExtra("phone") + ")");
        orderZipCode.setText(intent.getStringExtra("zipCode"));
        orderAddress.setText(intent.getStringExtra("address"));
        orderTotalPrice.setText(intent.getStringExtra("totalPrice"));

        RecyclerView orderView = findViewById(R.id.orderView);
        orderAdapter = new OrderAdapter(OrderActivity.this);
        orderView.setAdapter(orderAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        orderView.setLayoutManager(linearLayoutManager);

        orderSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(OrderActivity.this);
                alertDialog.setTitle("도서 상품 주문 완료");
                alertDialog.setMessage("주문해 주셔서 감사합니다");
                alertDialog.setIcon(R.drawable.dialog_cat);

                alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cartRepositoryObj.cartBooks.clear();
                        Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
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
        });

        orderCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(OrderActivity.this);
                alertDialog.setTitle("도서 상품 주문 취소");
                alertDialog.setMessage("주문을 취소합니다");
                alertDialog.setIcon(R.drawable.dialog_cat);

                alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cartRepositoryObj.cartBooks.clear();
                        Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
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
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}