package com.example.wirelesssmartcar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    static final UUID mUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    BluetoothDevice hc05;
    BluetoothSocket btSocket = null;
    // MAC ADDRESS HC-05: 98:D3:32:11:2D:8C
    TextView tvConnected;


    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonConnect = findViewById(R.id.buttonCon);
        final Button buttonDisconnect = findViewById(R.id.buttonDcon);

        final Button buttonLeft = findViewById(R.id.buttonL);
        final Button buttonRight = findViewById(R.id.buttonR);
        final Button buttonUp = findViewById(R.id.buttonU);
        final Button buttonDown = findViewById(R.id.buttonD);

        final TextView tv = findViewById(R.id.textView);
        tvConnected = findViewById(R.id.textViewConnected);
        final SeekBar sb = findViewById(R.id.seekBar);

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        System.out.println(btAdapter.getBondedDevices());

        hc05 = btAdapter.getRemoteDevice("98:D3:32:11:2D:8C");
        System.out.println(hc05.getName());



        buttonConnect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                connectHC05();
            }
        });
        buttonDisconnect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                disconnectHC05();
            }
        });

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText("LEFT");
            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText("RIGHT");
            }
        });
        buttonUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText("UP");
            }
        });
        buttonDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText("DOWN");
            }
        });



        }

    private void connectHC05(){
        int counter = 0;
        do {
            try {
                btSocket = hc05.createRfcommSocketToServiceRecord(mUUID);
                System.out.println(btSocket);
                btSocket.connect();
                System.out.println(btSocket.isConnected());
                tvConnected.setText("Connected: "+ btSocket.isConnected());
            } catch (IOException e) {
                e.printStackTrace();
            }
            counter++;
        } while (!btSocket.isConnected() && counter < 3);
    }

    private void disconnectHC05(){
        try {
            btSocket.close();
            System.out.println(btSocket.isConnected());
            tvConnected.setText("Connected: "+ btSocket.isConnected());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendBTData(char[] c){
        try {
            OutputStream outputStream = btSocket.getOutputStream();

            for(int i = 0; i< c.length; i++){
                outputStream.write(c[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendBTDataSingle(char c){
        try {
            OutputStream outputStream = btSocket.getOutputStream();
            outputStream.write(c);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte receiveBTData() {
        InputStream inputStream = null;
        try {
            inputStream = btSocket.getInputStream();
            inputStream.skip(inputStream.available());

            byte b = (byte) inputStream.read();
            return b;


        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

    }
        }
