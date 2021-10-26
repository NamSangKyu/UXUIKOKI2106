package com.example.day1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//

public class MainActivity extends AppCompatActivity {

    Button button;
    MainHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });

        handler = new MainHandler();
    }

    class BackgroundThread extends Thread{
        public void run(){
            for(int i =0; i <100; i++){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}

                Log.d("Thread test", "test"+ i);
//                button.setText("test thread");

                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("msg", "test handler");
                message.setData(bundle);
                handler.sendMessage(message);

            }
        }
    }

    class MainHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            String txt = bundle.getString("msg");

            button.setText(txt);
        }
    }
}