package com.example.ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    TextView tvObj1;
    TextView tvObj2;
    */

    /*
    Button btn1;
    TextView tvObj1;
    TextView tvObj2;
    String num1, num2;
    Integer result;
    */

    ImageView imgObj;
    TextView numObj;
    Button btnObj;
    Integer imgNumber[] = { R.drawable.cat01, R.drawable.cat02,
                            R.drawable.cat03, R.drawable.cat04,
                            R.drawable.cat05, R.drawable.cat06 };
    Integer index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Button myButton = new Button(this);

        myButton.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        myButton.setText("버튼");

        Button myButton2 = (Button) findViewById(R.id.button1);
        */

        /*
        TextView textView;

        textView = (TextView) findViewById(R.id.textViewId);
        textView.setText("Android App 배우기");
        textView.setTextColor(Color.parseColor("#03a9f4"));
        textView.setTextSize(50f);
        textView.setTypeface(Typeface.SERIF);
        */

        /*
        tvObj1 = findViewById(R.id.num1);
        tvObj2 = findViewById(R.id.num2);
        */

        /*
        tvObj1 = findViewById(R.id.num1);
        tvObj2 = findViewById(R.id.num2);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = tvObj1.getText().toString();
                num2 = tvObj2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_LONG).show();
            }
        });
        */

        /*
        EditText nameObj, passwordObj, emailObj, dateObj, phoneObj;
        Button btnObj;
        TextView resultObj;

        nameObj = findViewById(R.id.edtName);
        passwordObj = findViewById(R.id.edtPasswd);
        emailObj = findViewById(R.id.edtEmail);
        dateObj = findViewById(R.id.edtDate);
        phoneObj = findViewById(R.id.edtPhone);
        btnObj = findViewById(R.id.btnSend);
        resultObj = findViewById(R.id.txtResult);

        btnObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameObj.getText().toString().isEmpty() ||
                    passwordObj.getText().toString().isEmpty() ||
                    emailObj.getText().toString().isEmpty() ||
                    dateObj.getText().toString().isEmpty() ||
                    phoneObj.getText().toString().isEmpty()
                ) {
                    resultObj.setText("항목을 입력해주세요");
                } else {
                    resultObj.setText("성명: " + nameObj.getText().toString() + "\n" +
                            "비밀번호: " + passwordObj.getText().toString() + "\n" +
                            "이메일: " + emailObj.getText().toString() + "\n" +
                            "생년월일: " + dateObj.getText().toString() + "\n" +
                            "연락처: " + phoneObj.getText().toString());
                }
            }
        });
        */

        imgObj = findViewById(R.id.imageView);
        numObj = findViewById(R.id.txtIndex);
        btnObj = findViewById(R.id.btnNext);
        btnObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (index + 1) % imgNumber.length;
                imgObj.setImageResource(imgNumber[index]);
                numObj.setText(Integer.toString(index + 1) + "번 이미지");
            }
        });
    }

    /*
    public void onButtonClick(View view) {
        Toast.makeText(getApplicationContext(), "눌렀습니다", Toast.LENGTH_SHORT).show();
    }
    */

    /*
    public void onClickSum(View view) {
        String value1 = tvObj1.getText().toString();
        String value2 = tvObj2.getText().toString();
        int a = Integer.parseInt(value1);
        int b = Integer.parseInt(value2);
        int sum = a + b;
        Toast.makeText(getApplicationContext(), String.valueOf(sum), Toast.LENGTH_LONG).show();
    }
    */
}