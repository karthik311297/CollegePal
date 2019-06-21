package com.example.karthik.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Login extends AppCompatActivity {
    final HashMap<String,String> x=new HashMap<String,String>();
    FirebaseAuth.AuthStateListener autl;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b=(Button)findViewById(R.id.conT);
        firebaseAuth = FirebaseAuth.getInstance();
        autl=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(Login.this, "User logged in ", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(Login.this, newProfile.class);
                    startActivity(I);
                } else {
                    Toast.makeText(Login.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }};
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText u=(EditText)findViewById(R.id.emailaddr);
                EditText p=(EditText)findViewById(R.id.passWord);
                String us=u.getText().toString();
                String ps=p.getText().toString();

                if((!u.getText().toString().equals(""))&&(!p.getText().toString().equals(""))){
                    firebaseAuth.signInWithEmailAndPassword(u.getText().toString(),p.getText().toString()).addOnCompleteListener(Login.this, new OnCompleteListener< AuthResult >() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "Not successfull", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Login.this, newProfile.class));
                            }
                        }
                    });

                }
                else{
                    Toast.makeText(Login.this,"Fields cannot be empty",Toast.LENGTH_LONG).show();

                }

                /*
                if(x.containsKey(us)){
                    if(ps.equals(x.get(us))) {
                        Intent profile = new Intent(Login.this, Profile.class);
                        profile.putExtra("USERID",us);
                        startActivity(profile);
                    }
                    else{
                        Toast toast1 = Toast.makeText(Login.this, "incorrect password", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                }
                else
                    {
                        Toast toast2 = Toast.makeText(Login.this, "incorrect username", Toast.LENGTH_SHORT);
                        toast2.show();
                    }
                */
                }
        });
    }

}
