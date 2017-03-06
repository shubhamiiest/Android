package com.testing.firebase_login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText email ,password;
    ProgressDialog pd;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email= (EditText) findViewById(R.id.editText);
        password= (EditText) findViewById(R.id.editText2);
        pd=new ProgressDialog(Login.this);
        auth=FirebaseAuth.getInstance();
    }
    public void login(View v){
       String emailid = email.getText().toString();
        String pass = password.getText().toString();
        if(TextUtils.isEmpty(emailid)){
            Toast.makeText(Login.this,"Please enter email",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(emailid)){
            Toast.makeText(Login.this,"Please enter password",Toast.LENGTH_SHORT).show();
        }
        if(pass.length() < 6){
            Toast.makeText(Login.this,"Please enter password more than 6 characters",Toast.LENGTH_SHORT).show();
        }
        pd.setMessage("Please Wait");
        pd.setCancelable(true);
        pd.show();
        auth.signInWithEmailAndPassword(emailid,pass).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(! task.isSuccessful()){
                    pd.dismiss();
                    Toast.makeText(Login.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
                else{
                    pd.dismiss();
                    Toast.makeText(Login.this,"Logined Succesfully",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Login.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

    }
    public void forgot(View v){
         Intent i=new Intent(Login.this,Forgot_Password.class);
        startActivity(i);
    }
    public void signup(View v){

        Intent i=new Intent(Login.this,Signup.class);
        startActivity(i);
    }
}
