package com.example.karthik.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    DatabaseReference faculties;
    DatabaseReference projects;
    DatabaseReference events;
    DatabaseReference startups;
    DatabaseReference clubs;
    DatabaseReference domains;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        startups= FirebaseDatabase.getInstance().getReference("Startups");
        events= FirebaseDatabase.getInstance().getReference("Events");
        projects= FirebaseDatabase.getInstance().getReference("Projects");
        clubs=FirebaseDatabase.getInstance().getReference("Clubs");
        Button apb=(Button)findViewById(R.id.pend);
        Button ssb=(Button)findViewById(R.id.ssb);
        Button csb=(Button)findViewById(R.id.csb);
        Button psb=(Button)findViewById(R.id.psb);
        Button evsb=(Button)findViewById(R.id.evsb);
        ssb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText snm=(EditText)findViewById(R.id.snm);
                EditText cusn=(EditText)findViewById(R.id.sinc);
                Startupinfo si=new Startupinfo(snm.getText().toString(),cusn.getText().toString());
                String ids=startups.push().getKey();
                startups.child(ids).setValue(si);
                Toast.makeText(Profile.this,"Startup added to database",Toast.LENGTH_LONG).show();


            }
        });
        csb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText cnm=(EditText)findViewById(R.id.cnm);
                EditText cusn=(EditText)findViewById(R.id.cusn);
                Clubinfo clubx=new Clubinfo(cnm.getText().toString(),cusn.getText().toString());
                String ids=clubs.push().getKey();
                clubs.child(ids).setValue(clubx);
                Toast.makeText(Profile.this,"Club added to database",Toast.LENGTH_LONG).show();
            }
        });
        psb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ptl=(EditText)findViewById(R.id.ptl);
                EditText pnm=(EditText)findViewById(R.id.pjid);
                EditText purl=(EditText)findViewById(R.id.urltext);
                Spinner tspin=(Spinner)findViewById(R.id.Techspin);
                Spinner tspin2=(Spinner)findViewById(R.id.Techspin2);
                Spinner tspin3=(Spinner)findViewById(R.id.Techspin3);
                Projectinfo pj=new Projectinfo(ptl.getText().toString(),pnm.getText().toString(),purl.getText().toString(),tspin.getSelectedItem().toString(),tspin2.getSelectedItem().toString(),tspin3.getSelectedItem().toString());
                String ids=projects.push().getKey();
                projects.child(ids).setValue(pj);
                Toast.makeText(Profile.this,"Project added to database",Toast.LENGTH_LONG).show();

            }
        });
        evsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText conducted=(EditText)findViewById(R.id.evid);
                EditText evnm=(EditText)findViewById(R.id.evnm);
                EditText evven=(EditText)findViewById(R.id.evvenue);
                Eventinfo evi=new Eventinfo(conducted.getText().toString(),evnm.getText().toString(),evven.getText().toString());
                String ids=events.push().getKey();
                events.child(ids).setValue(evi);
                Toast.makeText(Profile.this,"Event added to database",Toast.LENGTH_LONG).show();

            }
        });
        apb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Profile.this,ApprovalsActivity.class);
                startActivity(i);
            }
        });

    }


}