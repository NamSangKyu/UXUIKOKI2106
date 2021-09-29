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
                view.setText(charSequence.length() + " / 80 글자");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


}