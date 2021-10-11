package com.example.justmath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity3 extends AppCompatActivity {
TextView textView3,tv6;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        
        textView3=findViewById(R.id.textView3);
        tv6=findViewById(R.id.textView6);
        Intent intent=getIntent();
        int ans=intent.getIntExtra("name",0);
        int[] a={0};
         //a=intent.getIntArrayExtra("name");
textView3.setText("your score: "+ans);
//tv6.setText( "time Occupied:"+ans);
    }
}