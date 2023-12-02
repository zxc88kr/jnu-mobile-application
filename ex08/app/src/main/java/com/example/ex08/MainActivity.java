package com.example.ex08;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etDate = findViewById(R.id.editTextDate);
        EditText etTime = findViewById(R.id.editTextTime);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String selMonth;
                        String selDay;

                        if ((month + 1) < 10) {
                            selMonth = "0" + (month + 1);
                        } else {
                            selMonth = Integer.toString(month + 1);
                        }

                        if (dayOfMonth < 10) {
                            selDay = "0" + dayOfMonth;
                        } else {
                            selDay = Integer.toString(dayOfMonth);
                        }

                        etDate.setText(Integer.toString(year) + "/" + selMonth + "/" + selDay);
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, listener, year, month, day);
                datePickerDialog.setTitle("날짜를 선택하세요");
                datePickerDialog.show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String state = "AM";
                        int selHour = hourOfDay;
                        int selMinute = minute;

                        if (selHour > 12) {
                            state = "PM";
                            selHour -= 12;
                        }

                        etTime.setText(state + " " + selHour + "시 " + selMinute + "분");
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, listener, hour, minute, true);
                timePickerDialog.setTitle("시간을 선택하세요");
                timePickerDialog.show();
            }
        });
    }
}