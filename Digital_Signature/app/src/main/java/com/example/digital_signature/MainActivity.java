package com.example.digital_signature;

import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    GestureOverlayView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        gv= (GestureOverlayView) findViewById(R.id.ges);

    }
    public void a(View v){
       try {
           //enables the drawing on the screen

               gv.setDrawingCacheEnabled(true);
           Bitmap bm=Bitmap.createBitmap(gv.getDrawingCache());//converts into bitmap
           //for storing the file
           //file separator is basically the slash
           //creates new file
           File f=new File(Environment.getExternalStorageDirectory()+File.separator+"sign.png");
           f.createNewFile();
           //for storing the image in created file
           FileOutputStream fo=new FileOutputStream(f);
           bm.compress(Bitmap.CompressFormat.PNG,100,fo);
           fo.close();
           Toast.makeText(this,"Saved Syccesfully",Toast.LENGTH_LONG).show();
       }
       catch (Exception e){

       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
