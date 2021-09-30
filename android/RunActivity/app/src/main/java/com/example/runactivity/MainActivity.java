package com.example.runactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText txt = findViewById(R.id.edt_txt);
        Button btnFirst = findViewById(R.id.btn_first);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("txt",txt.getText().toString());
                startActivity(intent);
            }
        });
        Button third = findViewById(R.id.btn_thrid);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivityForResult(intent,1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Third Activity Result
        if(requestCode == 1000){
            if(resultCode == RESULT_OK){
                Toast.makeText(this,"Finish Data : "+
                        data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Failed Data : "+
                        data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
            }
        }

    }
}


