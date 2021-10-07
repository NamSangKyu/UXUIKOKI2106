package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemberRegisterActivity extends AppCompatActivity {
    private TextView txtName;
    private TextView txtTel;
    private DBHelper dbHelper;
    private Button btnAdd;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_register);
        btnAdd = findViewById(R.id.register_btn_add);
        btnCancel = findViewById(R.id.register_btn_cancel);
        txtTel = findViewById(R.id.register_txt_tel);
        txtName = findViewById(R.id.register_txt_name);
        dbHelper = new DBHelper(getApplicationContext());
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, tel;
                name = txtName.getText().toString();
                tel = txtTel.getText().toString();
                dbHelper.add(new AddressVO(name, tel));
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}