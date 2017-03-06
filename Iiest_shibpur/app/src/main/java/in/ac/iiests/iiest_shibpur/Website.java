package in.ac.iiests.iiest_shibpur;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Website extends AppCompatActivity {

    Typeface tf;
    WebView w1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        t1= (TextView) findViewById(R.id.textView1);
        w1= (WebView) findViewById(R.id.webView1);
        tf=Typeface.createFromAsset(getAssets(),"xsimple.ttf");
        w1.getSettings().setJavaScriptEnabled(true);
        w1.getSettings().setDomStorageEnabled(true);
        w1.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                w1.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        w1.loadUrl("http://www.iiests.ac.in");

    }
    public void reload(View v){
        w1.reload();
    }
}
