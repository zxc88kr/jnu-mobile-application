package com.example.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

        /*
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }
        */

        /*
        String s = " Java Programming ";
        System.out.println("s.length(): " + s.length());
        System.out.println("s.charAt(1): " + s.charAt(1));
        System.out.println("s.substring(6): " + s.substring(6));
        System.out.println("s.substring(5, 13): " + s.substring(5, 13));
        System.out.println("s.indexOf('P'): " + s.indexOf('P'));
        System.out.println("s.toLowerCase(): " + s.toLowerCase());
        System.out.println("s.toUpperCase(): " + s.toUpperCase());
        */

        /*
        int result = mul(3, 5);
        System.out.println("사용자 정의 함수 mul()");
        System.out.println("두 수의 곱은 " + result);
        */

        /*
        Member myObj = new Member();
        myObj.name = "홍길동";
        myObj.age = 20;
        myObj.gender = 'F';
        myObj.printMemberInfo();

        Employee myEmp = new Employee();
        */

        List<String> lists = new ArrayList();
        lists.add("월요일");
        lists.add("화요일");
        lists.add("수요일");
        lists.add("목요일");
        lists.add("금요일");
        System.out.println(lists.size());
        System.out.println(lists.get(0));
        System.out.println(lists.contains("토요일"));
        System.out.println(lists.indexOf("화요일"));
    }

    /*
    int mul(int a, int b) {
        int number = a * b;
        return number;
    }
    */
}

/*
class Member {
    String name = "";
    int age = 0;
    char gender = 'M';

    void printMemberInfo() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("성별: " + gender);
    }
}

class Employee {
    int id = 202201;
    String name = "홍길순";

    Employee() {
        System.out.println("Employee 아이디: " + id);
        System.out.println("Employee 이름: " + name);
    }
}
*/