package com.testing.firebase_login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
;import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText email,password;
    FirebaseAuth auth;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email= (EditText) findViewById(R.id.emailid);
        password=(EditText) findViewById(R.id.pass);
        auth=FirebaseAuth.getInstance();
        pd=new ProgressDialog(Signup.this);



    }
    public void register(View v){
        String emailid = email.getText().toString();
        String pass = password.getText().toString();
        if(TextUtils.isEmpty(emailid)){
            Toast.makeText(Signup.this,"Enter email id",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(Signup.this,"Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(pass.length() < 6){
            Toast.makeText(Signup.this,"Password is too small",Toast.LENGTH_SHORT).show();
            return;
        }
        pd.setMessage("Please Wait");
        pd.setCancelable(false);
        pd.show();

        auth.createUserWithEmailAndPassword(emailid,pass).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                pd.dismiss();
                if(!task.isSuccessful()){
                    Toast.makeText(Signup.this,"Authentical Failed"+task.getException(),Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Signup.this,"Succesfully Registered",Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    public void reset(View v){
        Intent i=new Intent(Signup.this,Forgot_Password.class);
        startActivity(i);
    }

    public void login(View v){
        Intent i=new Intent(Signup.this,Login.class);
        startActivity(i);
    }
}
