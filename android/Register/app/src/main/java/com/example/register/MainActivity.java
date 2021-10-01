package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        EditText txtId = findViewById(R.id.txt_id);
        EditText txtPass = findViewById(R.id.txt_password);

        Button btn = findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = txtId.getText().toString();
                String pass = txtPass.getText().toString();
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