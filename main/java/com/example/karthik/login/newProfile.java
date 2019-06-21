package com.example.karthik.login;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class newProfile extends AppCompatActivity {
    DatabaseReference clubs;
    DatabaseReference events;
    DatabaseReference startups;
    DatabaseReference stud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profile);
        clubs= FirebaseDatabase.getInstance().getReference("Clubs");
        events= FirebaseDatabase.getInstance().getReference("Events");
        startups= FirebaseDatabase.getInstance().getReference("Startups");
        ArrayList<String>emty=new ArrayList<>();
        final ArrayAdapter<String>emtyadapter=new ArrayAdapter<>(newProfile.this,android.R.layout.simple_list_item_1,emty);
        final ListView dl=(ListView)findViewById(R.id.datalist);
        Button lgb=(Button)findViewById(R.id.log_out);
        lgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });
        Button cb=(Button)findViewById(R.id.clubButton);
        Button eb=(Button)findViewById(R.id.eventsbutton);
        Button sb=(Button)findViewById(R.id.startupsbutton);
        Button pb=(Button)findViewById(R.id.projectsbutton);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dl.setAdapter(emtyadapter);
                clubs.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        final ArrayList<Clubinfo>clublist=new ArrayList<>();
                        for(DataSnapshot ds :dataSnapshot.getChildren()){
                            Clubinfo cl=ds.getValue(Clubinfo.class);
                            clublist.add(cl);

                        }
                        Adaptlist cladapter=new Adaptlist(newProfile.this,clublist);
                        dl.setAdapter(cladapter);
                        dl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Clubinfo club=clublist.get(i);
                                Intent intent=new Intent(newProfile.this,DetailActivity.class);
                                intent.putExtra("USN",club.getInchargeusn());
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        eb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dl.setAdapter(emtyadapter);
                events.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        final ArrayList<String>eventlist=new ArrayList<>();
                        for(DataSnapshot ds:dataSnapshot.getChildren()){
                            Eventinfo e=ds.getValue(Eventinfo.class);
                            eventlist.add(e.getConducted()+":\t"+e.getName());
                        }
                        ArrayAdapter<String>evdapter=new ArrayAdapter<>(newProfile.this,android.R.layout.simple_list_item_1,eventlist);
                        dl.setAdapter(evdapter);
                        }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    pb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i =new Intent(newProfile.this,ProjsearchActivity.class);
            startActivity(i);
            }
    });
    sb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dl.setAdapter(emtyadapter);
            startups.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final ArrayList<Startupinfo>startuplist=new ArrayList<>();
                    for(DataSnapshot ds:dataSnapshot.getChildren()){
                        Startupinfo sin=ds.getValue(Startupinfo.class);
                        startuplist.add(sin);
                    }
                    Adaptlist2 sadapt=new Adaptlist2(newProfile.this,startuplist);
                    dl.setAdapter(sadapt);
                    dl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Startupinfo sup=startuplist.get(i);
                            Intent intent=new Intent(newProfile.this,DetailActivity.class);
                            intent.putExtra("USN",sup.getInchargeusn());
                            startActivity(intent);

                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    });
    Button senreq=(Button)findViewById(R.id.sendrequest);
    senreq.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(newProfile.this,RequestActivity.class);
            startActivity(i);
        }
    });

       }
}
