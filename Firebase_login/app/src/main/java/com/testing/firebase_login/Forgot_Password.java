package com.testing.firebase_login;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Password extends AppCompatActivity {

    EditText emailid;
    FirebaseAuth auth;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);
        emailid= (EditText) findViewById(R.id.editText);
        auth=FirebaseAuth.getInstance();
        pd=new ProgressDialog(Forgot_Password.this);

    }
    public void forgot(View v){
        String email= emailid.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(Forgot_Password.this,"Please enter ur email",Toast.LENGTH_SHORT).show();
        }
        pd.setMessage("Please Wait");
        pd.setCancelable(false);
        pd.show();
        auth.sendPasswordResetEmail(email).addOnCompleteListener(Forgot_Password.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Forgot_Password.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                    emailid.setText("");
                } else {
                    Toast.makeText(Forgot_Password.this, "Failed to send reset email !! This Email is not registerd !!", Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                }
            }
        });
    }
    public void signup(View v){
        Intent i=new Intent(Forgot_Password.this,Signup.class);
        startActivity(i);
    }
    public void login(View v){
        Intent i=new Intent(Forgot_Password.this,Login.class);
        startActivity(i);
    }
}
