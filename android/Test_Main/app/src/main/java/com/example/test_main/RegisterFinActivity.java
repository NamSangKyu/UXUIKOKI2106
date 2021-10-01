package com.example.test_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterFinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_fin);
        TextView view = findViewById(R.id.reg_fin_txt);
        Intent intent = getIntent();
        view.setText(String.format("%s님 회원가입이 완료되었습니다.",intent.getStringExtra("id")));
    }
}