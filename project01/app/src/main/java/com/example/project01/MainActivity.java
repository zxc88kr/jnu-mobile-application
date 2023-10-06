package com.example.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText numEdt1, numEdt2;
    Button addBtn, subBtn, mulBtn, divBtn;
    TextView resultTxt;
    String num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("계산기");

        numEdt1 = (EditText) findViewById(R.id.numEdt1);
        numEdt2 = (EditText) findViewById(R.id.numEdt2);

        addBtn = (Button) findViewById(R.id.addBtn);
        subBtn = (Button) findViewById(R.id.subBtn);
        mulBtn = (Button) findViewById(R.id.mulBtn);
        divBtn = (Button) findViewById(R.id.divBtn);

        resultTxt = (TextView) findViewById(R.id.resultTxt);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = numEdt1.getText().toString();
                num2 = numEdt2.getText().toString();
                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                    resultTxt.setText("none");
                } else {
                    resultTxt.setText(String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2)));
                }
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = numEdt1.getText().toString();
                num2 = numEdt2.getText().toString();
                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                    resultTxt.setText("none");
                } else {
                    resultTxt.setText(String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2)));
                }
            }
        });

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = numEdt1.getText().toString();
                num2 = numEdt2.getText().toString();
                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                    resultTxt.setText("none");
                } else {
                    resultTxt.setText(String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2)));
                }
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = numEdt1.getText().toString();
                num2 = numEdt2.getText().toString();
                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                    resultTxt.setText("none");
                } else if ("0".equals(num2)) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                    resultTxt.setText("NaN");
                } else {
                    resultTxt.setText(String.valueOf(Double.parseDouble(num1) / Integer.parseInt(num2)));
                }
            }
        });
    }
}