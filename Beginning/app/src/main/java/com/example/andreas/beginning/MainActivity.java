package com.example.andreas.beginning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SeekBar seekBar;
    TextView textView;
    int min = 0, max = 100, current = 50;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView2);
        textView = findViewById(R.id.textView3);
        textView = findViewById(R.id.textView4);
        textView = findViewById(R.id.textView5);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(max - min);
        seekBar.setProgress(current - min);
        textView.setText("" + current);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current = progress + min;
                textView.setText("" + current);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });





    }
}
