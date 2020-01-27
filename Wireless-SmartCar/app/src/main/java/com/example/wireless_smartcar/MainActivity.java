package com.example.wireless_smartcar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtView= (TextView)findViewById(R.id.txtViewTest);

        final Button button= (Button)findViewById(R.id.btnTest);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                txtView.setText(i++);

            }
        });





    }




}
