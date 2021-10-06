package com.example.address_step01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomListAdapter adapter = new CustomListAdapter();
        adapter.addItem(getDrawable(R.drawable.china),"China People","tel : 000-0000-0000, email : OOOO@gmail.com");
        adapter.addItem(getDrawable(R.drawable.fance),"France People","tel : 000-0000-0000, email : OOOO@gmail.com");
        adapter.addItem(getDrawable(R.drawable.japan),"Japan People","tel : 000-0000-0000, email : OOOO@gmail.com");
        adapter.addItem(getDrawable(R.drawable.united),"America People","tel : 000-0000-0000, email : OOOO@gmail.com");

        ListView list = findViewById(R.id.list_view);
        list.setAdapter(adapter);

    }
}