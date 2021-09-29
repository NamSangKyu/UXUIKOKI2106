package com.example.smsinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText sms = findViewById(R.id.txt_sms);
        Button btnSend = findViewById(R.id.btn_send);
        Button btnClose = findViewById(R.id.btn_close);
        TextView view = findViewById(R.id.text_length);
        sms.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Toast.makeText(getBaseContext(),charSequence,Toast.LENGTH_SHORT).show();
                Log.i("SMS", charSequence.length() + "  글자");
                //글자 개수 80글자가 넘으면 넘어가는 해당 글자들을 제거
                if(charSequence.length() > 80) {
                    Log.i("SMS", charSequence.subSequence(0, 80).toString());
                    sms.setText(charSequence.subSequence(0, 80));
                    sms.setSelection(80);//커서 위치 설정
                }
                view.setText(sms.getText().length() + " / 80 글자");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finishAndRemoveTask();//태스크 리스트에 남지 않음
                finish();//태스크 리스트에 남음
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),sms.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }


}