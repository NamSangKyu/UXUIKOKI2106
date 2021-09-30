package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LIFE", "onCreate");
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
}