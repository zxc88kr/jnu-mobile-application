package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

public class BooksActivity extends AppCompatActivity {
    ImageButton listBtn1, listBtn2;
    LinearLayout list1;
    TableLayout list2;
    ImageView book1_1, book2_1, book3_1, book4_1,
            book1_2, book2_2, book3_2, book4_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        listBtn1 = findViewById(R.id.listBtn1);
        listBtn2 = findViewById(R.id.listBtn2);
        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);

        book1_1 = findViewById(R.id.book1_1);
        book2_1 = findViewById(R.id.book2_1);
        book3_1 = findViewById(R.id.book3_1);
        book4_1 = findViewById(R.id.book4_1);

        book1_2 = findViewById(R.id.book1_2);
        book2_2 = findViewById(R.id.book2_2);
        book3_2 = findViewById(R.id.book3_2);
        book4_2 = findViewById(R.id.book4_2);

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

    public void onClickBook(View view) {
        if (view.getId() == book1_1.getId() || view.getId() == book1_2.getId()) {
            Toast.makeText(this, "자바 코딩의 기술", Toast.LENGTH_SHORT).show();

            Intent intent = makeIntent("BOOK1234", "자바 코딩의 기술", "22000", "2020-07-30",
                    "사이먼 하러, 리누스 디에츠, 요르그 레너드, 심지현", "264쪽", "코딩 스킬을 개선하는 가장 좋은 방법은 전문가의 코드를 읽는 것이다. 오픈 소스 코드를 읽으면서 이해하면 좋지만, 너무 방대하고 스스로 맥락을 찾는 게 어려울 수 있다. 그럴 땐 이 책처럼 현장에서 자주 발견되는 문제 유형 70가지와 해법을 비교하면서 자신의 코드에서 개선할 점을 찾는 것이 좋다.", "프로그래밍/오픈소스");

            startActivity(intent);
        } else if (view.getId() == book2_1.getId() || view.getId() == book2_2.getId()) {
            Toast.makeText(this, "머신 러닝을 다루는 기술", Toast.LENGTH_SHORT).show();

            Intent intent = makeIntent("BOOK1235", "머신 러닝을 다루는 기술", "34000", "2020-06-30",
                    "마크 페너, 황준식", "624쪽", "저자는 오랫동안 다양한 사람들에게 머신 러닝을 가르치면서 효과적인 학습 방법을 고안했고, 그대로 책에 담았다. 이 책은 그림과 스토리로 개념을 설명하고 바로 파이썬 코드로 구현하는 것에서 시작한다. 수학적 증명을 깊게 파고들거나 개념을 설명하기 위해 수식에 의존하지 않으며, 필요한 수학은 고등학교 수준으로 그때마다 첨가하여 설명한다. 또한, 바닥부터 모델을 구현하지 않고, 넘파이, 판다스, 사이킷런처럼 잘 구현된 강력한 파이썬 라이브러리를 사용해 실용적으로 접근한다. 개념과 기술을 잘 보여주는 양질의 예제를 직접 실행하며 머신 러닝 개념을 이해할 수 있다.", "데이터베이스/데이터분석");

            startActivity(intent);
        } else if (view.getId() == book3_1.getId() || view.getId() == book3_2.getId()) {
            Toast.makeText(this, "모던 리눅스 관리", Toast.LENGTH_SHORT).show();

            Intent intent = makeIntent("BOOK1236", "모던 리눅스 관리", "30000", "2019-10-10",
                    "데이비드 클린턴(David Cliton), 강석주", "472쪽", "이 책은 최신 기술을 활용한 리눅스 관리 방법을 가상화, 연결, 암호화, 네트워킹, 이미지관리, 시스템 모니터링의 6가지 주제로 나눠 설명한다. 가상 머신에 리눅스를 설치하고 서버를 구축하는 방법뿐만 아니라 구축 이후에 리눅스를 관리하고 운영하며 겪을수 있는 다양한 문제를 해결하는 방법까지 다룬다. VM과 컨테이너를 이용한 가상화, AWS S3를 이용한 데이터 백업, Nextcloud를 이용한 파일공유 서버 구축, 앤서블을 이용한 데브옵스 환경 구축 등 최신 기술을 활용한 실용적인 12가지 프로젝트로 실무에 필요한 리눅스 관리 방법을 배울 수 있다.", "임베디드/시스템/네트워크");

            startActivity(intent);
        } else if (view.getId() == book4_1.getId() || view.getId() == book4_2.getId()) {
            Toast.makeText(this, "유니티 교과서", Toast.LENGTH_SHORT).show();

            Intent intent = makeIntent("BOOK1237", "유니티 교과서", "28000", "2019-10-30",
                    "기타무라 마나미, 김은철, 유세라", "456쪽", "[유니티 교과서, 개정 3판]은 유니티를 사용해 2D/3D 게임과 애니메이션을 만들면서 유니티 기초 지식과 함께 게임 제작 흐름을 익히는 것을 목적으로 한다. 유니티를 설치한 후 C# 핵심 문법을 학습하고, 이어서 여섯 가지 2D/3D 게임을 ‘게임 설계하기 → 프로젝트와 씬 만들기 → 씬에 오브젝트 배치하기 → 스크립트 작성하기 → 스크립트 적용하기’ 단계로 만들어 보면서 게임 제작 흐름을 익힌다.", "게임");

            startActivity(intent);
        }
    }

    public Intent makeIntent(String id, String name, String price, String date,
                             String writer, String page, String description, String category) {
        Intent intent = new Intent(this, BookActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("date", date);
        intent.putExtra("writer", writer);
        intent.putExtra("page", page);
        intent.putExtra("description", description);
        intent.putExtra("category", category);
        return intent;
    }
}