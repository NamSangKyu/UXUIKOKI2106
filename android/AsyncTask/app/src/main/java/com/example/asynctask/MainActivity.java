package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar bar;
    Button btnRun;
    Button btnStop;
    int value=0;
    ProgressTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = findViewById(R.id.progressBar);
        btnRun = findViewById(R.id.btnRun);
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = new ProgressTask();
                task.execute();
            }
        });
        btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.cancel(true);
            }
        });
    }

    public class ProgressTask extends AsyncTask<Integer, Integer, Integer>{
        @Override
        protected void onPreExecute() {
            //백그라운드 작업 전에 실행, 초기화 작업
            super.onPreExecute();
            value=5;
            bar.setProgress(value);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            //결과값 받아서 UI 처리하는 부분
            super.onPostExecute(integer);
            bar.setProgress(0);
        }

        @Override
        protected void onCancelled() {
            bar.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Integer ... values) {
            //현재 작업 진행 상태 표시 --> 백스라운드에서 publishProgress 호출해야 실행됨
            super.onProgressUpdate(values);
            bar.setProgress(values[0]);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            //스레드 처리부분
            while(!isCancelled()){
                value++;
                if(value >= 100) break;
                else
                    publishProgress(value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return value;
        }
    }
}
