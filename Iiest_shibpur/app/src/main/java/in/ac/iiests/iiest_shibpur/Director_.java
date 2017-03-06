package in.ac.iiests.iiest_shibpur;

import android.graphics.Typeface;
import android.renderscript.Type;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Director_ extends AppCompatActivity {

    TextView t10;
    Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_);
        t10= (TextView) findViewById(R.id.textView1);
        tf= Typeface.createFromAsset(getAssets(),"xsimple.ttf");
        t10.setTypeface(tf);
    }
}
