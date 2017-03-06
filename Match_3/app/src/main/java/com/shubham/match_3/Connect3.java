package com.shubham.match_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Connect3 extends AppCompatActivity {

    Intent i;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);
        im = (ImageView) findViewById(R.id.imageView11);

        i= new Intent(Connect3.this,MainActivity.class);
        im.animate().rotation(720).setDuration(1000);
        Thread timer =new Thread(){
            @Override
            public void run() {
                try {

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
