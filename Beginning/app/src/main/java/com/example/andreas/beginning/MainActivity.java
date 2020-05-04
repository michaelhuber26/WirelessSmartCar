package com.example.andreas.beginning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    int min = 0, max = 100, current = 50;
    Button btnLeft, btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView5);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setProgress(max - min);
        seekBar.setProgress(current - min);
        textView.setText("" + current);

        btnLeft = findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {

                textView.setText("LEFT");
            }

        });


        btnRight = findViewById(R.id.btnRight);
        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {

                textView.setText("RIGHT");
            }

        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current = progress + min;
                textView.setText("" + current);
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
