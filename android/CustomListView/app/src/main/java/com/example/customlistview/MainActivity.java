package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView view = findViewById(R.id.list_view);
        CustomListAdapter customListAdapter = new CustomListAdapter();

        customListAdapter.addItem(getDrawable(R.drawable.cloud),"구름");
        customListAdapter.addItem(getDrawable(R.drawable.cloud_sun),"구름/해");
        customListAdapter.addItem(getDrawable(R.drawable.cloud),"구름");
        customListAdapter.addItem(getDrawable(R.drawable.cloud_sun),"구름/해");
        customListAdapter.addItem(getDrawable(R.drawable.cloud),"구름");
        customListAdapter.addItem(getDrawable(R.drawable.cloud_sun),"구름/해");
        customListAdapter.addItem(getDrawable(R.drawable.cloud),"구름");
        customListAdapter.addItem(getDrawable(R.drawable.cloud_sun),"구름/해");
        customListAdapter.addItem(getDrawable(R.drawable.cloud),"구름");
        customListAdapter.addItem(getDrawable(R.drawable.cloud_sun),"구름/해");

        view.setAdapter(customListAdapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListViewItem item = (ListViewItem) customListAdapter.getItem(i);
                Toast.makeText(MainActivity.this,item.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}