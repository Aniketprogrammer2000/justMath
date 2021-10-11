package com.example.justmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button share,click;
Intent intent1=new Intent();
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
share=findViewById(R.id.button);
click=findViewById(R.id.button2);
    }
boolean isResultCorrect;
    public void share(View view) {
        Intent intent=new Intent(this,MainActivity2.class);
         mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.ring2);
         mediaPlayer.start();
        startActivity(intent);
        }

    public void Share(View view) {
        intent1.setType("text/plain");

        startActivity(Intent.createChooser(intent1,"share"));
    }
}
