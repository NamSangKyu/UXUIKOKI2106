package com.example.test_main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtId = findViewById(R.id.main_txt_id);
        EditText edtPass1 = findViewById(R.id.main_txt_pass);
        EditText edtPass2 = findViewById(R.id.main_txt_passchk);
        CheckBox chk = findViewById(R.id.main_chk_agree);
        Button btn = findViewById(R.id.main_btn_register);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                if(edtId.getText().length() < 6)
                    str = "아이디는 6글자 이상 입력해야합니다.";
                else if(!edtPass1.getText().toString().equals(edtPass2.getText().toString()))
                    str = "암호는 일치해야 합니다.";
                else if(!chk.isChecked())
                    str = "약관 동의를 해야 가입이 가능합니다.";

                if(str.length()!=0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("오류");
                    builder.setMessage(str);
                    builder.setPositiveButton("yes", null);
                    builder.setNeutralButton("cancel", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }else{
                    Intent intent = new Intent(MainActivity.this,RegisterFinActivity.class);
                    intent.putExtra("id",edtId.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}