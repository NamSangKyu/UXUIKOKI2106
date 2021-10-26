package com.example.day1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//

public class MainActivity2 extends AppCompatActivity {

    Button button;

    Handler handler = new Handler();

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


    }

    class BackgroundThread extends Thread{
        public void run(){
            for(int i =0; i <100; i++){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}

                Log.d("Thread test", "test"+ i);
//                button.setText("test thread");
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        button.setText("test test");
//                    }
//                });

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setText("postDelayed");
                    }
                }, 5000);
            }
        }
    }

}