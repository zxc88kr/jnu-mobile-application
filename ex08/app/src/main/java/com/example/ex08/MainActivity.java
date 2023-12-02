package com.example.ex08;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int selectNum = 0;
    int oldNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String listItems[] = {"아기상어", "엄마상어", "아빠상어"};

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("상어가족");

                alertDialog.setSingleChoiceItems(listItems, oldNum, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0: selectNum = 0; break;
                            case 1: selectNum = 1; break;
                            case 2: selectNum = 2; break;

                        }
                    }
                });

                alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        switch (selectNum) {
                            case 0: imageView.setImageResource(R.drawable.baby); break;
                            case 1: imageView.setImageResource(R.drawable.mom); break;
                            case 2: imageView.setImageResource(R.drawable.papa); break;
                        }
                        textView.setText(listItems[selectNum]);
                        oldNum = selectNum;
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
    }
}