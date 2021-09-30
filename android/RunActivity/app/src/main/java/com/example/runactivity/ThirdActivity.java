package com.example.runactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button btnSuccess = findViewById(R.id.btn_success);
        Button btnFail = findViewById(R.id.btn_fail);

        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result","TTTTTTT");
                setResult(RESULT_OK,intent);//Activity Exit return intent
                finish();
            }
        });
        btnFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result","FFFFFFF");
                setResult(RESULT_CANCELED,intent);//Activity Exit return intent
                finish();
            }
        });
    }
}