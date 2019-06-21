package com.example.karthik.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailActivity extends AppCompatActivity {
    DatabaseReference stud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        final String usn=intent.getStringExtra("USN");
        stud= FirebaseDatabase.getInstance().getReference("Students");
        stud.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds :dataSnapshot.getChildren()){
                    Stuinfo cl=ds.getValue(Stuinfo.class);
                    if(cl.getUsn().equals(usn)){
                        TextView txt=(TextView)findViewById(R.id.studetails);
                        String z=cl.getName()+"\n"+cl.getPhno()+"\n"+cl.getDept();
                        txt.setText(z);
                        break;
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
