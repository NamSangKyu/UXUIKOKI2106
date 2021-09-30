package com.example.toastsnackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText xpos = findViewById(R.id.txt_x);
        EditText ypos = findViewById(R.id.txt_y);

        Button btn = findViewById(R.id.btn_toast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //레이아웃 인플레이터 객체
                LayoutInflater inflater = getLayoutInflater();

                View layout = inflater.inflate(R.layout.toast,(ViewGroup) findViewById(R.id.toast_root));

                Toast toast = Toast.makeText(getApplicationContext(),"Toast Message",Toast.LENGTH_SHORT);
                int x = Integer.parseInt(xpos.getText().toString());
                int y = Integer.parseInt(ypos.getText().toString());
                Log.i("POS", String.format("onClick: %d, %d",x,y));
                toast.setGravity(Gravity.TOP|Gravity.LEFT,x,y);
                toast.setView(layout);
                toast.show();
            }
        });

        Button btnSnack = findViewById(R.id.btn_snack);
        btnSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "snack bar area",Snackbar.LENGTH_SHORT).show();
            }
        });

        Button btnAlert = findViewById(R.id.btn_alert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("title");
                builder.setMessage("alert content");
                builder.setIcon(android.R.drawable.ic_dialog_alert);//icon setting

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar.make(view, "touch yes", Snackbar.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar.make(view, "touch Cancel", Snackbar.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar.make(view, "touch No", Snackbar.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}






