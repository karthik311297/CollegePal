package com.example.karthik.login;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProjsearchActivity extends AppCompatActivity {

    DatabaseReference projects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projsearch);
        final ArrayList<Projectinfo> localsearch=new ArrayList<>();
        final ArrayList<Projectinfo> projectlist=new ArrayList<>();
        final ListView pl=(ListView)findViewById(R.id.projslist);
        Button b=(Button)findViewById(R.id.sbutn);
        projects= FirebaseDatabase.getInstance().getReference("Projects");

        projects.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds:dataSnapshot.getChildren()) {
                    Projectinfo p = ds.getValue(Projectinfo.class);
                    projectlist.add(p);
                }
                Adaptlist3 pdapt=new Adaptlist3(ProjsearchActivity.this,projectlist);
                pl.setAdapter(pdapt);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText src=(EditText)findViewById(R.id.searchtech);
                localsearch.clear();
                Adaptlist3 emtyadapt = new Adaptlist3(ProjsearchActivity.this,localsearch);
                pl.setAdapter(emtyadapt);
                if(!src.getText().toString().equals("")) {
                    for (int i = 0; i < projectlist.size(); i++) {
                        Projectinfo pif = projectlist.get(i);
                        if (pif.getTechnology().toLowerCase().equals(src.getText().toString()) || pif.getTechnology2().toLowerCase().equals(src.getText().toString()) || pif.getTechnology3().toLowerCase().equals(src.getText().toString())) {
                            localsearch.add(pif);
                        }
                    }
                    Adaptlist3 pdapt1 = new Adaptlist3(ProjsearchActivity.this, localsearch);
                    pl.setAdapter(pdapt1);
                }
                else {
                    Adaptlist3 pdapt2 = new Adaptlist3(ProjsearchActivity.this, projectlist);
                    pl.setAdapter(pdapt2);
                }

            }
        });



    }
}
