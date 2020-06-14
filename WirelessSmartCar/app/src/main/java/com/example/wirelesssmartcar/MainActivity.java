package com.example.wirelesssmartcar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonLeft = findViewById(R.id.buttonL);
        final Button buttonRight = findViewById(R.id.buttonR);
        final Button buttonUp = findViewById(R.id.buttonU);
        final Button buttonDown = findViewById(R.id.buttonD);

        final TextView tv = findViewById(R.id.textView);
        final SeekBar sb = findViewById(R.id.seekBar);


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
        }
