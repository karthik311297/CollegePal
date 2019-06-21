package com.example.karthik.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class EditApprovals extends AppCompatActivity {
    DatabaseReference events;
    DatabaseReference approvals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_approvals);
        events= FirebaseDatabase.getInstance().getReference("Events");
        approvals= FirebaseDatabase.getInstance().getReference("Approvals");


        Intent i=getIntent();
        String x=i.getStringExtra("c");
        String y=i.getStringExtra("n");
        String z=i.getStringExtra("v");
        final EditText x1=(EditText)findViewById(R.id.appcond);

        final EditText x2=(EditText)findViewById(R.id.appnm);

        final EditText x3=(EditText)findViewById(R.id.appven);
        x1.setText(x);
        x2.setText(y);
        x3.setText(z);
        Button ab=(Button)findViewById(R.id.approvebutton);

        Button nab=(Button)findViewById(R.id.notApprovebutton);
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Eventinfo evi=new Eventinfo(x1.getText().toString(),x2.getText().toString(),x3.getText().toString());
                String ids=events.push().getKey();
                events.child(ids).setValue(evi);
                Toast.makeText(EditApprovals.this,"Event approved and added to database",Toast.LENGTH_LONG).show();

                //changes
                Query q1=approvals.orderByChild("name").equalTo(x2.getText().toString());
                q1.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot nmsnap:dataSnapshot.getChildren()){
                            nmsnap.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                //...
            }
        });
        nab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //changes
                Query q1=approvals.orderByChild("name").equalTo(x2.getText().toString());
                q1.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot nmsnap:dataSnapshot.getChildren()){
                            nmsnap.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                //...
            }
        });
    }
}
