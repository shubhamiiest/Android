package in.ac.iiests.iiest_shibpur;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Test extends AppCompatActivity {
    TextView t7,t8;
    Typeface tf,tf1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Director Profile", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        t7= (TextView) findViewById(R.id.textView7);
        t8= (TextView) findViewById(R.id.textView8);
        tf=Typeface.createFromAsset(getAssets(),"xsimple.ttf");
        tf1=Typeface.createFromAsset(getAssets(),"penguin.ttf");
        t7.setTypeface(tf1);
        t8.setTypeface(tf);

    }

}
