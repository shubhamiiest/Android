package in.ac.iiests.iiest_shibpur;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Mainpage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView t2,t3,t4;
    Typeface tf1,tf2;
    ImageView im;
    AnimationDrawable ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "IIEST SHIBPUR - WE OWN IT", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        tf1=Typeface.createFromAsset(getAssets(),"xsimple.ttf");
        tf2=Typeface.createFromAsset(getAssets(),"penguin.ttf");
        t2= (TextView) findViewById(R.id.textView2);
        t3= (TextView) findViewById(R.id.textView3);
        t4= (TextView) findViewById(R.id.textView4);
        im= (ImageView) findViewById(R.id.imageView3);
        ad= (AnimationDrawable) im.getDrawable();
        t2.setTypeface(tf1);
        t3.setTypeface(tf2);
        t4.setTypeface(tf2);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        ad.start();
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainpage, menu);
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
           finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.id1) {
            Intent i1=new Intent(Mainpage.this,About_institute.class);
            startActivity(i1);
        }
        /*else if (id == R.id.id2) {
            Intent i2=new Intent(Mainpage.this,Institute.class);
            startActivity(i2);
        } else if (id == R.id.id3) {
            Intent i3=new Intent(Mainpage.this,Academics.class);
            startActivity(i3);
        } else if (id == R.id.id4) {
            Intent i4=new Intent(Mainpage.this,Research.class);
            startActivity(i4);
        } else if (id == R.id.id5) {
            Intent i5=new Intent(Mainpage.this,Industry.class);
            startActivity(i5);
        } else if (id == R.id.id6) {
            Intent i6=new Intent(Mainpage.this,Event.class);
            startActivity(i6);
        }
        else if (id == R.id.id7) {
            finish();
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void website(View v){
        Intent i=new Intent(Mainpage.this,Website.class);
        startActivity(i);
    }
}
