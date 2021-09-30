package com.example.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        View view = findViewById(R.id.view);
        View view2 = findViewById(R.id.view2);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                float xPos = motionEvent.getX();
                float yPos = motionEvent.getY();
                String str = "";
                if(action == MotionEvent.ACTION_DOWN){
                    str = String.format("손가락 누름 - xpos : %f, ypos : %f",xPos,yPos);
                }else if(action == MotionEvent.ACTION_MOVE){
                    str = String.format("손가락 움직임 - xpos : %f, ypos : %f",xPos,yPos);
                }else if(action == MotionEvent.ACTION_UP){
                    str = String.format("손가락 뗌 - xpos : %f, ypos : %f",xPos,yPos);
                }

                textView.setText(textView.getText()+"\n"+str);
                return true;
            }
        });
        GestureDetector detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                textView.setText(textView.getText()+"\n"+"onDown()");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                textView.setText(textView.getText()+"\n"+"onPress()");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                textView.setText(textView.getText()+"\n"+"onSingleTapUp()");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                textView.setText(textView.getText()+"\n"+"onScroll()");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                textView.setText(textView.getText()+"\n"+"onLongPress()");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                textView.setText(textView.getText()+"\n"+"onFling()");
                return true;
            }
        });
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return false;
            }
        });
    }
}