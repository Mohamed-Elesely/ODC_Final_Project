package com.example.fnal.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fnal.R;

public class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView=findViewById(R.id.imagelogo);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        imageView.startAnimation(myanim);
        final Intent i = new Intent(MainActivity.this,OnBoarding.class);
        Thread timer = new Thread(){
            public  void run(){
                try {
                    sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();

    }
}