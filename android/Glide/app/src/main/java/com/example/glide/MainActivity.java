package com.example.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    CustomListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.listView);
        adapter = new CustomListAdapter();
        adapter.AddItem("이미지 URL","제목1","내용1");
        adapter.AddItem("이미지 URL","제목2","내용2");
        adapter.AddItem("이미지 URL","제목3","내용3");
        adapter.AddItem("이미지 URL","제목4","내용4");
        list.setAdapter(adapter);

    }
}