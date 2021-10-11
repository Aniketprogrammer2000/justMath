package com.example.justmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
int i=0;
//MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sreen);
        getSupportActionBar().hide();

        if(i==0){
        Thread thread=new Thread() {
            public void run() {
                try {
                    sleep(2000);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                   //mediaPlayer= MediaPlayer.create(SplashScreen.this,R.raw.ring);
                   // mediaPlayer.start();
                    startActivity(intent);
                    finish();

                }

            }


        };thread.start();
   // onPause();
        }

    }
}