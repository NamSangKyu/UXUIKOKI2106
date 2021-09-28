package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);
        flag = false;
        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        Button btn = findViewById(R.id.btn_change);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = !flag;
                if(flag) {
                    //이미지뷰 자체를 번갈아가면서 숨김 표시 처리
//                    imageView.setVisibility(View.VISIBLE);
//                    imageView2.setVisibility(View.INVISIBLE);
                    //이미지뷰의 이미지를 변경
                      imageView2.setImageResource(R.drawable.github);
                }else{
//                    imageView.setVisibility(View.INVISIBLE);
//                    imageView2.setVisibility(View.VISIBLE);
                    imageView2.setImageResource(R.drawable.facebook);
                }
            }
        });
    }


}