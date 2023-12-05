package com.example.ex09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    MyAdapter adapter;
    ArrayList<MyItem> catsList;
    int selectItemPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catsList = new ArrayList<MyItem>();

        catsList.add(new MyItem("아비시니안", "활발하고 온순한 성격", "3~5kg", R.drawable.abyssinian));
        catsList.add(new MyItem("샴", "놀기 좋아하고 온순한 성격", "3.6~5.4kg", R.drawable.siamese));
        catsList.add(new MyItem("앙고라", "예인하고 상냥한 성격", "3.7~7kg", R.drawable.angora));
        catsList.add(new MyItem("랙돌", "느긋하고 온순한 성격", "5~9kg", R.drawable.regdol));

        Button btInsert = findViewById(R.id.button1);
        Button btModify = findViewById(R.id.button2);
        Button btDelete = findViewById(R.id.button3);

        listview = findViewById(R.id.listview);
        adapter = new MyAdapter(catsList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyItem itemValue = (MyItem) parent.getItemAtPosition(position);
                selectItemPos = position;
                Toast.makeText(getApplicationContext(), itemValue.getName() + " " + itemValue.getCharacter(), Toast.LENGTH_SHORT).show();
            }
        });

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count;
                count = adapter.getCount();

                catsList.add(new MyItem(
                        "러시안블루" + Integer.toString(count + 1),
                        "온순하고 애교 많은 성격",
                        "3.5~5kg",
                        R.drawable.russianblue));
                adapter.notifyDataSetChanged();
            }
        });

        btModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count;
                int checked;
                count = adapter.getCount();

                if (count > 0) {
                    checked = selectItemPos;
                    if (checked > -1 && checked < count) {
                        String nameKor = catsList.get(checked).name;
                        String nameEng = catsList.get(checked).character;
                        String version = "몸무게 " + catsList.get(checked).weight;
                        int image = catsList.get(checked).image;
                        catsList.set(checked, new MyItem(nameKor, nameEng, version, image));
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count;
                int checked;
                count = adapter.getCount();

                if (count > 0) {
                    checked = selectItemPos;
                    if (checked > -1 && checked < count) {
                        catsList.remove(checked);
                        listview.clearChoices();
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}