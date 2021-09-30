package com.example.progressseekbar;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = findViewById(R.id.seekBar);
        ProgressBar bar = findViewById(R.id.progressBar);
        TextView textView = findViewById(R.id.textView);
        LinearLayout layout = findViewById(R.id.main_layout);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                bar.setProgress(i);
                textView.setText(String.valueOf(i));
                ImageView imageView= new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.google);
                if(i==100)
                    layout.addView(imageView);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}