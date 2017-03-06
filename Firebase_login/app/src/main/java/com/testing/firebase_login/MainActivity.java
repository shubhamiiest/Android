package com.testing.firebase_login;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView email,welcome;
    FirebaseAuth auth;
    //DatabaseReference dr;
    Typeface tf,tf1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //firebase
        auth=FirebaseAuth.getInstance();
      //  dr = FirebaseDatabase.getInstance().getReference();
        //firebase
        email=(TextView) findViewById(R.id.textView9);
        welcome=(TextView) findViewById(R.id.textView5);
        tf=Typeface.createFromAsset(getAssets(),"xray.ttf");
        tf1=Typeface.createFromAsset(getAssets(),"penguin.ttf");
        welcome.setTypeface(tf);
        email.setTypeface(tf1);

        if(auth.getCurrentUser() == null){
            startActivity(new Intent(this,Login.class));

        }
        FirebaseUser user=auth.getCurrentUser();
        email.setText("'"+user.getEmail()+"'");

    }
    public void logout(View v){
        auth.signOut();
        finish();
        startActivity(new Intent(this,Login.class));
    }
    public void saveinfo(View v){
        Intent i =new Intent(MainActivity.this,Profile_info.class);
        startActivity(i);
        finish();
    }
}
