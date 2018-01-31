package com.gdg.makeup.makeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SPLASHSCREEN extends AppCompatActivity {

    long Lokaci = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Timer gudu = new Timer();
        TimerTask ShowSplash = new TimerTask(){
            public void run(){
                finish();
                Intent nextIntent = new Intent(SPLASHSCREEN.this,MainActivity.class);
                startActivity(nextIntent);
            }
        };
        gudu.schedule(ShowSplash, Lokaci);
    }
}