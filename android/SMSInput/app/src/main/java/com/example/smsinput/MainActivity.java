package com.example.smsinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        sms.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Toast.makeText(getBaseContext(),sms.getText(),Toast.LENGTH_SHORT).show();
                Log.i("SMS", "onEditorAction: " + keyEvent.getAction());
                return false;
            }
        });

    }


}