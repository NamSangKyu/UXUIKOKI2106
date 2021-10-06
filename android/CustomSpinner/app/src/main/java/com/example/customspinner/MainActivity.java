package com.example.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        TextView textView = findViewById(R.id.textView);

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter();
        adapter.addItem(getDrawable(R.drawable.china),"중국");
        adapter.addItem(getDrawable(R.drawable.fance),"프랑스");
        adapter.addItem(getDrawable(R.drawable.united),"미국");
        adapter.addItem(getDrawable(R.drawable.japan),"일본");
        spinner.setAdapter(adapter);
    }
}