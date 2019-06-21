package com.example.karthik.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
    /*final ArrayList<String> x=new ArrayList<String>();*/
    FirebaseAuth firebaseAuth;
    DatabaseReference studata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();
        studata= FirebaseDatabase.getInstance().getReference("Students");
        /*
        x.add("apple");
        x.add("xiaomi");
        x.add("onePlus");
        x.add("letv");
        x.add("samsung");
        x.add("micromax");
        */
        Button b=(Button)findViewById(R.id.signup);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e = (EditText) findViewById(R.id.eid);
                final EditText p = (EditText) findViewById(R.id.pwd);
                final EditText n = (EditText) findViewById(R.id.name1);
                final EditText d = (EditText) findViewById(R.id.date1);
                final EditText p1 = (EditText) findViewById(R.id.phn1);
                final EditText u = (EditText) findViewById(R.id.usn1);
                final Spinner spin=(Spinner)findViewById(R.id.deptspin);
                if((!e.getText().toString().equals(""))&&(!p.getText().toString().equals(""))){
                firebaseAuth.createUserWithEmailAndPassword(e.getText().toString(),p.getText().toString()).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //display some message here
                            Stuinfo s=new Stuinfo(n.getText().toString(),d.getText().toString(),p1.getText().toString(),u.getText().toString(),spin.getSelectedItem().toString());
                            studata.child(firebaseAuth.getCurrentUser().getUid()).setValue(s);
                            Toast.makeText(signup.this,"Student details added",Toast.LENGTH_LONG).show();
                            Toast.makeText(signup.this,"Successfully registered",Toast.LENGTH_LONG).show();
                            finish();
                        }else{
                            //display some message here
                            Toast.makeText(signup.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                    }
                });}
                else{
                    Toast.makeText(signup.this,"Fields cannot be empty",Toast.LENGTH_LONG).show();
                }
                /*
                if (!x.contains(userName)) {
                    String emailid = "\n" + e.getText().toString();
                    String passWord = "\n" + p.getText().toString();
                    String details = userName + emailid + passWord;

                    Intent profile = new Intent(signup.this, Login.class);
                    if (gm.isChecked()) {
                        details = details + "\n" + "Male";
                        profile.putExtra("Details", details);
                    }
                    if(gfm.isChecked()){
                        details = details + "\n" + "Female";
                        profile.putExtra("Details", details);
                    }
                    startActivity(profile);
                }
                else {
                    Toast toast1 = Toast.makeText(signup.this, "username already taken", Toast.LENGTH_SHORT);
                    toast1.show();
                }*/
                }
            });
    }
}
