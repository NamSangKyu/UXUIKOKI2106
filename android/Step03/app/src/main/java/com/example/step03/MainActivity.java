package com.example.step03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        EditText txt = findViewById(R.id.txt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = txt.getText().toString(); //뷰에 설정된 데이터 읽기
                Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG).show();
                txt.setText("수정된 메세지"); //뷰에 데이터 쓰기
            }
        });
    }
}