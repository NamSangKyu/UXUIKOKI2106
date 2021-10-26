package com.example.client;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//

public class NetSocketActivity extends AppCompatActivity {

    Button button;


    Handler handler = new Handler();

    EditText editText;

    TextView textClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);

        editText = findViewById(R.id.editText);
        textClient = findViewById(R.id.txClient);


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String data = editText.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send(data);
                    }
                }).start();
            }
        });

    }

    public void send(String data){
        int portNumber = 6006;

        Socket socket = null;
        try {
            socket = new Socket("localhost", portNumber);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(data);
            outputStream.flush();
            clientLog("server conn");

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            clientLog("server res data :" + inputStream.readObject());

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clientLog(final String data){
        handler.post(new Runnable() {
            @Override
            public void run() {
                textClient.append(data + "\n");
            }
        });
    }





}