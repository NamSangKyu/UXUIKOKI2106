package com.example.androidthread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    int count;
    NumberHandler handler;
    Handler defaultHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        handler = new NumberHandler();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberThread thread = new NumberThread();
                thread.start();
            }
        });
    }
    public class NumberThread extends Thread{
        @Override
        public void run() {
            for(int i=0;i<10;i++) {
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //핸들러로 전달할 메세지
//                Message msg = handler.obtainMessage();
//                Bundle bundle = new Bundle();
//                bundle.putInt("count",count);
//                msg.setData(bundle);
//                handler.sendMessage(msg);
                 handler.post(new Runnable() {
                     @Override
                     public void run() {
                         textView.setText("count : " + count);
                     }
                 });
            }
        }
    }
    class NumberHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int count = bundle.getInt("count");
            textView.setText("count : " + count);
        }
    }
}












