package in.ac.iiests.iiest_shibpur;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Rhighlights extends AppCompatActivity {
    Typeface tf;
    TextView t1;
    ListView l1;

    String s[] = { "SUCCESSFUL DESIGN AND PROTOTYPE PATIENT SPECIFIC BON AND SPINAL IMPLANTS DEVELOPMENT AT IIEST", "BIO-MEDICAL DETECTION UNIT FOR FOOD TOXINS AND PATHOGENIC VIRUSES", "SAFE HOME: MONITORING SYSTEM FOR LONE ELDERLY PEOPLE – IIEST INNOVATION",
            "DEVELOPMENT OF OPTICAL NANOFIBERS FOR DETECTION OF AFLATOXIN","AUTOMATED EARLY CANCER DIAGNOSIS SYSTEMS FOR HABITUAL SMOKERS","And Many More" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhighlights);
        t1= (TextView) findViewById(R.id.textView1);
        l1= (ListView) findViewById(R.id.listView1);
        tf=Typeface.createFromAsset(getAssets(),"xsimple.ttf");
        t1.setTypeface(tf);
        ArrayAdapter<String> call=new ArrayAdapter<String>(Rhighlights.this,android.R.layout.simple_list_item_1,s);
        l1.setAdapter(call);

    }
}
