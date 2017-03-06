package in.ac.iiests.iiest_shibpur;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Startscreen extends AppCompatActivity {

    Intent i;
    TextView t1,t6;
    Typeface tf,tf1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);
        tf=Typeface.createFromAsset(getAssets(),"xsimple.ttf");
        tf1=Typeface.createFromAsset(getAssets(),"xray.ttf");
        t1= (TextView) findViewById(R.id.textView);
        t6= (TextView) findViewById(R.id.textView6);
        t1.setTypeface(tf);

        t6.setTypeface(tf1);
        i=new Intent(Startscreen.this,Homepage.class);
        Thread timer =new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                }
                //super.run();
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }
}
