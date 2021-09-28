package com.example.step01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //레이아웃에 배치된 버튼 선택
        Button btn1 = findViewById(R.id.btn_first);
        //클릭 이벤트 설정 - 인터페이스와 익명 클래스를 이용하여 이벤트 설정
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"first 버튼을 눌렀습니다.",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onButtonClick(View view){
        Toast.makeText(getBaseContext(),"두번째 버튼을 눌렀습니다.",Toast.LENGTH_LONG).show();
    }
}







