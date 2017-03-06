package in.ac.iiests.iiest_shibpur;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Campus extends AppCompatActivity {
    TextView t7;
    Typeface tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);
        t7= (TextView) findViewById(R.id.textView7);
        tf = Typeface.createFromAsset(getAssets(), "xray.ttf");
        t7.setTypeface(tf);
    }
}
