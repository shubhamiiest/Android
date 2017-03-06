package com.shubham.flappybird;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    Intent i;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        im = (ImageView) findViewById(R.id.imageView);
        i =new Intent(StartActivity.this,Flappybird.class);
        //im.animate().rotation(720).setDuration(1000);
        Thread timer =new Thread(){
            @Override
            public void run() {
                try{
                    sleep(1500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                }
                super.run();
            }
        };
        timer.start();
    }
}
