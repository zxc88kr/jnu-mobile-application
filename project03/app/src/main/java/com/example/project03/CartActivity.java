package com.example.project03;

import static com.example.project03.MainActivity.cartRepositoryObj;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project03.adapter.CartAdapter;
import com.example.project03.model.Book;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    CartAdapter cartAdapter;

    static CheckBox cartSelectAllObj;
    static TextView cartTotalPriceObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartSelectAllObj = findViewById(R.id.cartSelectAll);
        cartTotalPriceObj = findViewById(R.id.cartTotalPrice);

        cartSelectAllObj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) doSelectAll();
                else doSelectNone();
            }
        });

        cartTotalPriceObj.setText(Integer.toString(cartRepositoryObj.getTotalPrice()));

        RecyclerView cartView = findViewById(R.id.cartView);
        cartAdapter = new CartAdapter(CartActivity.this);
        cartView.setAdapter(cartAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cartView.setLayoutManager(linearLayoutManager);

        cartAdapter.setOnSelectChangedListener(new CartAdapter.OnSelectChangedListener() {
            @Override
            public void onSelectChanged(ArrayList<Book> item) {
                refreshRecyclerView();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cart, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.menuDelete:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(CartActivity.this);
                alertDialog.setTitle("도서 상품 삭제");
                alertDialog.setMessage("장바구니에 담은 상품을 모두 삭제하겠습니까?");
                alertDialog.setIcon(R.drawable.dialog_cat);

                alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cartRepositoryObj.cartBooks.clear();
                        setSelectAllCheckBoxState();
                        cartUpdate();
                    }
                });
                alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
                break;
            case R.id.menuOrder:
                Intent intent = new Intent(CartActivity.this, BooksActivity.class); // 수정 필요
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void doSelectAll() {
        int num = cartAdapter.getItemCount();
        if (num > 0) {
            boolean isChanged = false;
            for (int i = 0; i < num; i++) {
                Book item = cartRepositoryObj.cartBooks.get(i);
                if (!item.isChecked) {
                    item.isChecked = true;
                    isChanged = true;
                }
            }
            if (isChanged) {
                refreshRecyclerView();
            }
        }
    }

    void doSelectNone() {
        int num = cartAdapter.getItemCount();
        if (num > 0) {
            boolean isChanged = false;
            for (int i = 0; i < num; i++) {
                Book item = cartRepositoryObj.cartBooks.get(i);
                if (item.isChecked) {
                    item.isChecked = false;
                    isChanged = true;
                }
            }
            if (isChanged) {
                refreshRecyclerView();
            }
        }
    }

    private void refreshRecyclerView() {
        cartAdapter.notifyItemRangeRemoved(0, cartRepositoryObj.cartBooks.size());
        cartTotalPriceObj.setText(Integer.toString(cartRepositoryObj.getTotalPrice()));
        setSelectAllCheckBoxState();
    }

    private void setSelectAllCheckBoxState() {
        if (cartRepositoryObj.cartBooks == null) {
            cartSelectAllObj.setChecked(false);
            return;
        }
        for (int i = 0; i < cartRepositoryObj.cartBooks.size(); i++) {
            if (!cartRepositoryObj.cartBooks.get(i).isChecked) {
                cartSelectAllObj.setChecked(false);
                return;
            }
        }
        cartSelectAllObj.setChecked(true);
    }

    public static void cartUpdate() {
        cartRepositoryObj.getTotalQuantity();
        cartTotalPriceObj.setText(Integer.toString(cartRepositoryObj.getTotalPrice()));
    }
}