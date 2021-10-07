package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnRegister;
    DBHelper dbHelper;
    TextView txtSearch;
    ImageButton imgButton;
    LinearLayout linearLayout;
    List<AddressVO> list;
    boolean filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filter = false;
        linearLayout = findViewById(R.id.main_scroll_linear);
        txtSearch = findViewById(R.id.main_txt_search);
        imgButton = findViewById(R.id.main_btn_search);
        dbHelper = new DBHelper(this);
        btnRegister = findViewById(R.id.main_btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MemberRegisterActivity.class);
                startActivityForResult(intent,1000);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        filter = false;
        dbHelper = new DBHelper(this);
        linearLayout.removeAllViews();
        list = dbHelper.selectAllAddressVO();
        for(int i=0;i<list.size();i++){
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            String content = list.get(i).getName() + "\t\t" +list.get(i).getTel();
            TextView txt = new TextView(this);
            txt.setText(content);
            txt.setTextSize(16);
            txt.setPadding(30,0,0,0);
            TextView id = new TextView(this);
            String mid = String.valueOf(list.get(i).getId());
            id.setText(mid);
            id.setTextSize(20);
            id.setVisibility(View.INVISIBLE);
            row.addView(id);
            row.addView(txt);
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            linearLayout.addView(row);
        }
    }
}








