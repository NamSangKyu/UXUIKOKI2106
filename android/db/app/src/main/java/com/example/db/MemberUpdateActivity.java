package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemberUpdateActivity extends AppCompatActivity {
    AddressVO vo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_update);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String tel = intent.getStringExtra("tel");
        int id = intent.getIntExtra("id",0);
        vo = new AddressVO(id,name,tel);
        EditText txtName = findViewById(R.id.update_txt_name);
        EditText txtTel = findViewById(R.id.update_txt_tel);
        txtName.setText(intent.getStringExtra("name"));
        txtTel.setText(intent.getStringExtra("tel"));
        Button btnDelete = findViewById(R.id.update_btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MemberUpdateActivity.this);
                dbHelper.delete(vo.getId());
                finish();
            }
        });
        Button btnUpdate = findViewById(R.id.update_btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String tel = txtTel.getText().toString();
                DBHelper dbHelper = new DBHelper(MemberUpdateActivity.this);
                vo.setName(name);
                vo.setTel(tel);
                dbHelper.update(vo);
                finish();
            }
        });
        Button btnCancel = findViewById(R.id.update_btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}