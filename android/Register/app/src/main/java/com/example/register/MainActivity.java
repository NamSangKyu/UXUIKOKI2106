package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText txtId = findViewById(R.id.txt_id);
        EditText txtPass = findViewById(R.id.txt_password);
        CheckBox box = findViewById(R.id.checkBox);
        Button btn = findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = txtId.getText().toString();
                String pass = txtPass.getText().toString();
                //isChecked로 체크박스가 체크가 되어 있는지 안되어 있는지 체크
                Toast.makeText(getBaseContext(),String.valueOf(box.isChecked()),Toast.LENGTH_SHORT).show();
                if(id.equals("koreait") && pass.equals("123456")){
                    Intent intent = new Intent(MainActivity.this,BoardListActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getBaseContext(),"아이디와 비밀번호를 확인하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}