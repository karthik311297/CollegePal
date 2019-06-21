package com.example.karthik.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ApprovalsActivity extends AppCompatActivity {
    DatabaseReference approvals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approvals);
        final ListView dl=(ListView)findViewById(R.id.eventapplist);
        approvals= FirebaseDatabase.getInstance().getReference("Approvals");
        approvals.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final ArrayList<Approvals> clublist=new ArrayList<>();
                for(DataSnapshot ds :dataSnapshot.getChildren()){
                    Approvals cl=ds.getValue(Approvals.class);
                    clublist.add(cl);

                }
                Adapter4 cladapter=new Adapter4(ApprovalsActivity.this,clublist);
                dl.setAdapter(cladapter);
                dl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Approvals club=clublist.get(i);
                        Intent j=new Intent(ApprovalsActivity.this,EditApprovals.class);
                        j.putExtra("c",club.getConducted());
                        j.putExtra("n",club.getName());
                        j.putExtra("v",club.getVenue());
                        startActivity(j);
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
