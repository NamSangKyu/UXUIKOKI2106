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
        adapter.AddItem("https://pbs.twimg.com/media/EviLd44UcAU4_lw.jpg","제목1","내용1");
        adapter.AddItem("https://pbs.twimg.com/media/EviLd44UcAU4_lw.jpg1","제목2","내용2");
        adapter.AddItem("https://pbs.twimg.com/media/EviLd44UcAU4_lw.jpg2","제목3","내용3");
        adapter.AddItem("https://t1.daumcdn.net/cfile/tistory/99B75C495C5402CF35","제목4","내용4");
        list.setAdapter(adapter);

    }
}