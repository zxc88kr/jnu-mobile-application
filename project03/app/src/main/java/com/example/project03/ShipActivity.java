package com.example.project03;

import static com.example.project03.MainActivity.cartRepositoryObj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShipActivity extends AppCompatActivity {
    EditText shipName, shipDate, shipPhone, shipZipCode, shipAddress;
    Button shipSubmitBtn, shipCancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship);

        shipName = findViewById(R.id.shipName);
        shipDate = findViewById(R.id.shipDate);
        shipPhone = findViewById(R.id.shipPhone);
        shipZipCode = findViewById(R.id.shipZipCode);
        shipAddress= findViewById(R.id.shipAddress);

        shipSubmitBtn = findViewById(R.id.shipSubmitBtn);
        shipCancelBtn = findViewById(R.id.shipCancelBtn);

        shipSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShipActivity.this, OrderActivity.class);
                intent.putExtra("name", shipName.getText().toString());
                intent.putExtra("date", shipDate.getText().toString());
                intent.putExtra("phone", shipPhone.getText().toString());
                intent.putExtra("zipCode", shipZipCode.getText().toString());
                intent.putExtra("address", shipAddress.getText().toString());
                intent.putExtra("totalPrice", Integer.toString(cartRepositoryObj.getTotalPrice()));
                startActivity(intent);
                finish();
            }
        });

        shipCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShipActivity.this, CartActivity.class);
                startActivity(intent);
                finish();
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