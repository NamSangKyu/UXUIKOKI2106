package com.example.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerItem item = (SpinnerItem) adapter.getItem(i);
                //Toast.makeText(MainActivity.this,item.getText(),Toast.LENGTH_SHORT).show();
                textView.setText(item.getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}