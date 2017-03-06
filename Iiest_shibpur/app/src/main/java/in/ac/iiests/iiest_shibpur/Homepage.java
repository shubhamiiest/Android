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
import android.widget.Toast;

public class Homepage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView im;
    AnimationDrawable ad;
    Typeface tf,tf1,tf2;
    TextView t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "DIRECTOR - AJOY KUMAR ROY", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        im= (ImageView) findViewById(R.id.imageView3);
        t2= (TextView) findViewById(R.id.textView2);
        t4= (TextView) findViewById(R.id.textView4);
        t3= (TextView) findViewById(R.id.textView3);
        tf=Typeface.createFromAsset(getAssets(),"xsimple.ttf");
        tf1=Typeface.createFromAsset(getAssets(),"penguin.ttf");
        tf2=Typeface.createFromAsset(getAssets(),"xxx.ttf");
        ad= (AnimationDrawable) im.getDrawable();
        t2.setTypeface(tf);
        t3.setTypeface(tf1);
        t4.setTypeface(tf1);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        ad.start();
        super.onWindowFocusChanged(hasFocus);
    }

    public void dir(View v){
        Intent i=new Intent(Homepage.this,Director_.class);
        startActivity(i);
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
        getMenuInflater().inflate(R.menu.homepage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.id1) {
            Toast.makeText(Homepage.this,"Made By Shubham Pandey",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.id1) {
            // Handle the camera action
            Intent i1=new Intent(Homepage.this,Homepage.class);
            startActivity(i1);
        } else if (id == R.id.id2) {
            Intent i2=new Intent(Homepage.this,Institute_.class);
            startActivity(i2);

        } else if (id == R.id.id3) {
            Intent i3=new Intent(Homepage.this,Academics.class);
            startActivity(i3);

        } else if (id == R.id.id4) {
            Intent i3=new Intent(Homepage.this,Research.class);
            startActivity(i3);
        } else if (id == R.id.id5) {
            Intent i3=new Intent(Homepage.this,Industry.class);
            startActivity(i3);

        } else if (id == R.id.id6) {
            Intent i3=new Intent(Homepage.this,Event.class);
            startActivity(i3);}
        else if (id == R.id.id8) {
                Intent i3=new Intent(Homepage.this,Enquiry.class);
                startActivity(i3);

        }else if (id == R.id.id7) {
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void website(View v){
        Intent i=new Intent(Homepage.this,Website.class);
        startActivity(i);
        finish();
    }

}
