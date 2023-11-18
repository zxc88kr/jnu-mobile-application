package com.example.ex05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox cbObj1, cbObj2, cbObj3;
    Button btnObj;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbObj1=findViewById(R.id.checkBox1);
        cbObj2=findViewById(R.id.checkBox2);
        cbObj3=findViewById(R.id.checkBox3);
        btnObj=findViewById(R.id.button);

        btnObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = "selected cb: \n";
                if (cbObj1.isChecked())
                    result += "checkbox1,";
                if (cbObj2.isChecked())
                    result += "checkbox2,";
                if (cbObj3.isChecked())
                    result += "checkbox3,";
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });

        cbObj1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    Toast.makeText(getApplicationContext(), "cb1 selected", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "cb1 unselected", Toast.LENGTH_LONG).show();
            }
        });

        cbObj2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    Toast.makeText(getApplicationContext(), "cb2 selected", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "cb2 unselected", Toast.LENGTH_LONG).show();
            }
        });
        cbObj3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    Toast.makeText(getApplicationContext(), "cb3 selected", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "cb3 unselected", Toast.LENGTH_LONG).show();
            }
        });
    }
}