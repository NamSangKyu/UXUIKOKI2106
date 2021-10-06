package com.example.address_step01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class AddressDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_detail);
        ImageView detail = findViewById(R.id.detail_img);
        TextView name = findViewById(R.id.detail_txt_name);
        TextView content = findViewById(R.id.detail_txt_detail);

        Intent intent = getIntent();
        Log.i("CODE", "onCreate: "+intent.getStringExtra("profile"));
        detail.setImageResource(Integer.parseInt(intent.getStringExtra("profile")));
        name.setText(intent.getStringExtra("name"));
        content.setText(intent.getStringExtra("content").replace(", ","\n"));
    }
}