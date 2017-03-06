package in.ac.iiests.iiest_shibpur;

import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Institute extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Typeface tf;
    TextView t5;
    ListView l1;
    String s[] = {"ABOUT DIRECTOR","Vision & Mission", "Campus", "Visitor's Info","Contact Info"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Shubham Pandey", Snackbar.LENGTH_LONG)
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
        t5= (TextView) findViewById(R.id.textView5);
        l1= (ListView) findViewById(R.id.listView);
        tf = Typeface.createFromAsset(getAssets(), "xray.ttf");
        t5.setTypeface(tf);
        ArrayAdapter<String> call=new ArrayAdapter<String>(Institute.this,android.R.layout.simple_list_item_1,s);
        l1.setAdapter(call);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent i0=new Intent(Institute.this,Director.class);
                        startActivity(i0);
                        break;
                    case 1:
                        Intent i1=new Intent(Institute.this,Vission.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2=new Intent(Institute.this,Campus.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3=new Intent(Institute.this,Visitor.class);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4=new Intent(Institute.this,Contact.class);
                        startActivity(i4);
                        break;
                }


            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.id1) {
            Toast.makeText(Institute.this,"App By Shubham Pandey",Toast.LENGTH_LONG).show();
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
            Intent i1=new Intent(Institute.this,Homepage.class);
            startActivity(i1);
        } else if (id == R.id.id2) {
            Intent i2=new Intent(Institute.this,Institute.class);
            startActivity(i2);

        } else if (id == R.id.id3) {
            Intent i3=new Intent(Institute.this,Academics.class);
            startActivity(i3);

        } else if (id == R.id.id4) {
            Intent i3=new Intent(Institute.this,Research.class);
            startActivity(i3);
        } else if (id == R.id.id5) {
            Intent i3=new Intent(Institute.this,Industry.class);
            startActivity(i3);

        } else if (id == R.id.id6) {
            Intent i3=new Intent(Institute.this,Event.class);
            startActivity(i3);

        }
        else if (id == R.id.id8) {
            Intent i3=new Intent(Institute.this,Enquiry.class);
            startActivity(i3);

        }
        else if (id == R.id.id7) {
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
