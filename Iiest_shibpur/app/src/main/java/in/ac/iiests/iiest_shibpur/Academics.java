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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Academics extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView t1;
    Spinner s;
    ListView l1;
    Typeface tf;
    String ss[] = { "Choose Option", "ACADEMICS PROGRAMS", "CURRICULUM",
            "ACADEMIC UNITS", "SCHOOLS" };
    String s0[] = { "Integrated Dual Degree (B.Tech. - M.Tech.)",
            "Bachelor of Technology (B.Tech.)",
            "Bachelor of Architecture (B.Arch.)",
            "Master of Technology (M.Tech.)",
            "Master of Urban and Regional Planning (M.U.R.P.)",
            "Master of Science (M.Sc.)",
            "Master of Business Administration (M.B.A)" };
    String s2[] = { "Academic Calendar", "Integrated Dual Degree",
            "Bachelor of Engineering", "Master of Technology",
            "Master of Urban and Regional Planning",
            "Master of Science (M.Sc.)", "Master of Business Administration" };
    String s3[] = { "Aerospace Engineering and Applied Mechanics",
            "Architecture, Town, and Regional Planning", "Chemistry",
            "Civil Engineering ", "Computer Science and Technology",
            "Earth Sciences", "Electrical Engineering",
            "Electronics and Telecommunication Engineering",
            "Human Resource Management", "Humanities and Social Sciences",
            "Information Technology", "Mathematics", "Mechanical Engineering",
            "Metallurgy and Materials Engineering", "Mining Engineering",
            "Physics" };
    String s4[] = { "Purabi Das School of Information Technology",
            "Dr M.N. Dastur School of Materials Science and Engineering",
            "School of Management Sciences",
            "School of Community Science and Technology​",
            "School of Disaster Mitigation Engineering",
            "School of Ecology, Environment, and Human Settlement Management",
            "School of Mechatronics and Robotics", "School of VLSI Technology" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academics);
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
        tf=Typeface.createFromAsset(getAssets(),"xsimple.ttf");
        t1= (TextView) findViewById(R.id.textView1);
        l1= (ListView) findViewById(R.id.listView1);
        s= (Spinner) findViewById(R.id.spinner1);
        t1.setTypeface(tf);
        ArrayAdapter<String> call=new ArrayAdapter<String>(Academics.this,android.R.layout.simple_dropdown_item_1line,ss);
        s.setAdapter(call);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        ArrayAdapter<String> call0=new ArrayAdapter<String>(Academics.this,android.R.layout.simple_list_item_1,s0);
                        l1.setAdapter(call0);
                        break;
                    case 2:
                        ArrayAdapter<String> call1=new ArrayAdapter<String>(Academics.this,android.R.layout.simple_list_item_1,s2);
                        l1.setAdapter(call1);
                        break;
                    case 3:
                        ArrayAdapter<String> call2=new ArrayAdapter<String>(Academics.this,android.R.layout.simple_list_item_1,s3);
                        l1.setAdapter(call2);
                        break;
                    case 4:
                        ArrayAdapter<String> call3=new ArrayAdapter<String>(Academics.this,android.R.layout.simple_list_item_1,s4);
                        l1.setAdapter(call3);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
            Toast.makeText(Academics.this,"App By Shubham Pandey",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.id1) {
            Intent i1=new Intent(Academics.this,Homepage.class);
            startActivity(i1);
        } else if (id == R.id.id2) {
            Intent i2=new Intent(Academics.this,Institute_.class);
            startActivity(i2);
        } else if (id == R.id.id3) {
            Intent i3=new Intent(Academics.this,Academics.class);
            startActivity(i3);
        } else if (id == R.id.id4) {
            Intent i4=new Intent(Academics.this,Research.class);
            startActivity(i4);
        } else if (id == R.id.id5) {
            Intent i5=new Intent(Academics.this,Industry.class);
            startActivity(i5);
        } else if (id == R.id.id6) {
            Intent i6=new Intent(Academics.this,Event.class);
            startActivity(i6);
        }
        else if (id == R.id.id8) {
            Intent i3=new Intent(Academics.this,Enquiry.class);
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
