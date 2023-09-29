package com.example.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        int myAge = 20;
        myAge = 25;
        System.out.println("나의 나이는 " + myAge);
        */

        /*
        int myInt = 20;
        long myLong = 25L;
        System.out.println("Int: " + myInt);
        System.out.println("Long: " + myLong);
        int minInt = Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Int 값 범위: " + minInt + " ~ " + maxInt);
        long minLong = Long.MIN_VALUE;
        long maxLong = Long.MAX_VALUE;
        System.out.println("Long 값 범위: " + minLong + " ~ " + maxLong);
        */

        /*
        float myFloat = 30.2f;
        double myDouble = 35.4;
        System.out.println("Float: " + myFloat);
        System.out.println("Double: " + myDouble);
        float minFloat = Float.MIN_VALUE;
        float maxFloat = Float.MAX_VALUE;
        System.out.println("Float 값 범위: " + minFloat + " ~ " + maxFloat);
        double minDouble = Double.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;
        System.out.println("Double 값 범위: " + minDouble + " ~ " + maxDouble);
        */

        /*
        boolean myBoolean = true;
        System.out.println("Boolean: " + myBoolean);
        */

        /*
        String myString1 = "JAVA\n";
        String myString2 = "Java";
        System.out.print("String: " + myString1);
        System.out.println("String: " + myString2);
        */

        /*
        int[] myArr = new int[5];
        myArr[0] = 10;
        myArr[1] = 20;
        myArr[2] = 30;
        myArr[3] = 40;
        myArr[4] = 50;
        System.out.println("배열의 3번째 값: " + myArr[2]);
        int myArray[] = new int[]{1, 2, 3, 4, 5};
        System.out.println("배열의 3번째 값: " + myArray[2]);
        */
    }
}