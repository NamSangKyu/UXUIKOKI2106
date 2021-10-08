package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MemberUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_update);
        Intent intent = getIntent();
        EditText txtName = findViewById(R.id.update_txt_name);
        EditText txtTel = findViewById(R.id.update_txt_tel);
        txtName.setText(intent.getStringExtra("name"));
        txtTel.setText(intent.getStringExtra("tel"));
    }
}