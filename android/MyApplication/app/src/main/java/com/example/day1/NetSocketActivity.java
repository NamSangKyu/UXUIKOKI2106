package com.example.day1;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//

public class NetSocketActivity extends AppCompatActivity {
    Button button2;

    Handler handler = new Handler();
    TextView textServer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);
        textServer = findViewById(R.id.txServer);


        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startServer();
                    }
                }).start();
            }
        });
    }

    public void startServer(){

        try{
            int portNumber = 6006;

            ServerSocket serverSocket = new ServerSocket(portNumber); // start
            serverLog("start");
            while(true){
                //accept
                java.net.Socket socket = serverSocket.accept();

                InetAddress clientHost = socket.getLocalAddress();
                int clientPort = socket.getPort();
                serverLog("accept");

                //recv
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                Object obj = inputStream.readObject();
                serverLog("recv" + obj);

                //send
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(obj);
                outputStream.flush();
                serverLog("send" + obj);

                socket.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void serverLog(final String data){
        handler.post(new Runnable() {
            @Override
            public void run() {
                textServer.append(data + "\n");
            }
        });
    }



}