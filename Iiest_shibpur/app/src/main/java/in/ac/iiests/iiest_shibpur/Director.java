package in.ac.iiests.iiest_shibpur;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Director extends AppCompatActivity {

    Typeface tf;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director);
        t= (TextView) findViewById(R.id.textView1);
        tf=Typeface.createFromAsset(getAssets(),"xsimple.ttf");
        t.setTypeface(tf);
    }
}
