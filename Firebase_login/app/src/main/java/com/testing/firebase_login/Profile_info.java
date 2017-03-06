package com.testing.firebase_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile_info extends AppCompatActivity {

    EditText name,mobile,pin;
    FirebaseAuth auth;
    DatabaseReference dr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);
        auth=FirebaseAuth.getInstance();
        dr= FirebaseDatabase.getInstance().getReference();
        name=(EditText)findViewById(R.id.editText3);
        mobile=(EditText)findViewById(R.id.editText5);
        pin=(EditText)findViewById(R.id.editText6);
    }
    public void save(View v){
        String n=name.getText().toString().trim();
        String m=mobile.getText().toString().trim();
        String p=pin.getText().toString().trim();
        userinfo u=new userinfo(n,m,p);
        FirebaseUser user=auth.getCurrentUser();

        dr.child(user.getUid()).setValue(u);
        Toast.makeText(Profile_info.this,"Saved succesfully",Toast.LENGTH_LONG).show();
    }
}
