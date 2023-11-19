package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;

public class BooksActivity extends AppCompatActivity {
    ImageButton listBtn1, listBtn2;
    LinearLayout list1;
    TableLayout list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        listBtn1 = findViewById(R.id.listBtn1);
        listBtn2 = findViewById(R.id.listBtn2);
        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);

        getSupportActionBar().hide();
    }

    public void onClickList(View view) {
        if (view.getId() == listBtn1.getId()) {
            listBtn1.setImageResource(R.drawable.list_type1);
            listBtn2.setImageResource(R.drawable.list_type22);
            list1.setVisibility(View.VISIBLE);
            list2.setVisibility(View.INVISIBLE);
        } else if (view.getId() == listBtn2.getId()) {
            listBtn1.setImageResource(R.drawable.list_type12);
            listBtn2.setImageResource(R.drawable.list_type2);
            list1.setVisibility(View.INVISIBLE);
            list2.setVisibility(View.VISIBLE);
        }
    }
}