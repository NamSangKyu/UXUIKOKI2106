package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LIFE", "onCreate");
        TextView textView = findViewById(R.id.textView);
        textView.setText("Data Setting");
        EditText editText = findViewById(R.id.edt_txt);
        Button btn = findViewById(R.id.button);

        if(savedInstanceState != null){
            str = savedInstanceState.getString("str");
            Toast.makeText(this,"Data Load",Toast.LENGTH_SHORT).show();
        }

        Log.d("LIFE", "onCreate: "+str);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = editText.getText().toString();
                Toast.makeText(MainActivity.this,str+" content save", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFE", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFE", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFE", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFE", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFE", "onResume");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("str",str);
    }
}