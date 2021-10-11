package com.example.justmath;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

@SuppressLint("SetTextI18n")
public class MainActivity2 extends AppCompatActivity {

    TextView tv,tv5,tv7;
    Boolean isResultCorrect;
    Button Correct, Wrong;
    MediaPlayer mediaPlayer,mediaPlayer1,mediaPlayer2;
    int score=0;
    boolean stopTimer=true;
    TextView textView;
    @SuppressLint("SetTextI18n")
    void rand(){
        isResultCorrect = true;
Random random=new Random();
int a=random.nextInt(100);
int b=random.nextInt(100);
float f=random.nextFloat();
        int add=0;
if(f>0.5f) {
    
    isResultCorrect = false;
}
String symb[]={"+","-"};
int n=random.nextInt(2);
if(symb[n]=="+"){
    if(isResultCorrect) {
add=a+b;
        tv.setText(a + "+" + b + "\n\n=" + add+"?");
    }
    if(!isResultCorrect)
    {
        add = random.nextInt(100);
        tv.setText(a+"+"+b+"\n\n="+add+"?");
}}
else
    {

        if(isResultCorrect) {
            add=a-b;
            tv.setText(a + "-" + b + "\n\n=" + add+"?");
        }
        if(!isResultCorrect){
        add = random.nextInt(100);
            tv.setText(a+"-"+b+"\n\n="+add+"?");
    }}
    }
    /*protected void onPause() {
        super.onPause();
        mediaPlayer1.release();
    }*/

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv7=findViewById(R.id.textView7);

        getSupportActionBar().hide();
        mediaPlayer1=MediaPlayer.create(MainActivity2.this,R.raw.tictock1);
CountDownTimer countDownTimer=new CountDownTimer(600000,1000){
            int i=0;
            @Override
            public void onTick(long millisUntilFinished) {

                if(stopTimer){
                    mediaPlayer1.start();
                textView.setText("Time:"+String.valueOf(i));
                    i++;
                    mediaPlayer1.start();
                    mediaPlayer1.start();
            }
            }
           @Override
            public void onFinish() {

               /* if (!stopTimer) {
                    // stopTimer = false;
                    mediaPlayer1.stop();
                    Intent intent2=new Intent(MainActivity2.this,MainActivity3.class);
                    intent2.putExtra("name",score);
                    startActivity(intent2);
                    finish();

                }*/
                if(i>=20){
                    mediaPlayer1.stop();
                    Intent intent2=new Intent(MainActivity2.this,MainActivity3.class);
                    intent2.putExtra("name",score);
                    startActivity(intent2);
                    finish();
                }
            }
        };
if(stopTimer)countDownTimer.start();
if(!stopTimer) {
    countDownTimer.cancel();

}
        Correct = findViewById(R.id.Correct);
        Wrong = findViewById(R.id.Wrong);
        Intent intent2=new Intent(MainActivity2.this,MainActivity3.class);
        tv = findViewById(R.id.textView2);
        textView=findViewById(R.id.textView5);
        rand();
        Correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2 = MediaPlayer.create(MainActivity2.this, R.raw.ring1);
                mediaPlayer2.start();
                //mediaPlayer1.start();
if(isResultCorrect) {
    score++;
tv7.setText("Score:"+score);
}
                   if (!isResultCorrect) {
                        intent2.putExtra("name", score);
//if(!stopTimer)
    //intent2.putExtra("name1",i[0]);
mediaPlayer1.reset();
stopTimer=false;

                        startActivity(intent2);
                        finish();
                }
                rand();
            }

        });

        Wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(MainActivity2.this, R.raw.ring);
                mediaPlayer.start();
                //mediaPlayer1.start();
                if(!isResultCorrect) {
                    score++;
                    tv7.setText("Score:"+score);
                }

                //rand();
                if(isResultCorrect){
                    intent2.putExtra("name",score);
//if(!stopTimer)
                    //intent2.putExtra("name1",i[0]);
mediaPlayer1.stop();
stopTimer=false;


                    startActivity(intent2);
                    finish();
                }
                rand();
            }


        });
        Intent intent = getIntent();

}

    @Override
    protected void onPause() {
        super.onPause();

        mediaPlayer1.release();
    }
}