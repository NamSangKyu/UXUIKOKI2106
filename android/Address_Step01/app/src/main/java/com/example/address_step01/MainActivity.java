package com.example.address_step01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomListAdapter adapter = new CustomListAdapter();
        adapter.addItem(getDrawable(R.drawable.china),"China People","tel : 000-0000-0000, email : OOOO@gmail.com",R.drawable.china);
        adapter.addItem(getDrawable(R.drawable.fance),"France People","tel : 000-0000-0000, email : OOOO@gmail.com",R.drawable.fance);
        adapter.addItem(getDrawable(R.drawable.japan),"Japan People","tel : 000-0000-0000, email : OOOO@gmail.com",R.drawable.japan);
        adapter.addItem(getDrawable(R.drawable.united),"America People","tel : 000-0000-0000, email : OOOO@gmail.com",R.drawable.united);

        ListView list = findViewById(R.id.list_view);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListViewItem item = (ListViewItem) adapter.getItem(i);
                Toast.makeText(MainActivity.this,item.getName() + "/" + item.getContent(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,AddressDetailActivity.class);
                Log.i("profile", "onItemClick: "+item.getProfileId());
                intent.putExtra("profile",String.valueOf(item.getProfileId()));
                intent.putExtra("name",item.getName());
                intent.putExtra("content",item.getContent());
                startActivity(intent);
            }
        });

    }
}