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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Industry extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String s[] = { "Industry -Institute Partnership Cell", "Tagore Center for Green Technology Business Incubation (TCGTBI) AND PLACEMENTS",
            "All information Regarding Trainning and Placement can be found under the page of Human Resource Management" };
    ListView l1;
    TextView t1;
    Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        l1 = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> call = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, s);
        l1.setAdapter(call);
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
            Toast.makeText(Industry.this,"App By Shubham Pandey",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.id1) {
            Intent i1=new Intent(Industry.this,Homepage.class);
            startActivity(i1);
        } else if (id == R.id.id2) {
            Intent i2=new Intent(Industry.this,Institute_.class);
            startActivity(i2);
        } else if (id == R.id.id3) {
            Intent i3=new Intent(Industry.this,Academics.class);
            startActivity(i3);
        } else if (id == R.id.id4) {
            Intent i4=new Intent(Industry.this,Research.class);
            startActivity(i4);
        } else if (id == R.id.id5) {
            Intent i5=new Intent(Industry.this,Industry.class);
            startActivity(i5);
        } else if (id == R.id.id6) {
            Intent i6=new Intent(Industry.this,Event.class);
            startActivity(i6);
        }
        else if (id == R.id.id8) {
            Intent i3=new Intent(Industry.this,Enquiry.class);
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
