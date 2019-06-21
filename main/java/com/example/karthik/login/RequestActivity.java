package com.example.karthik.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RequestActivity extends AppCompatActivity {
    DatabaseReference approvals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        approvals= FirebaseDatabase.getInstance().getReference("Approvals");

        Button b=(Button)findViewById(R.id.reqb);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText x=(EditText)findViewById(R.id.entcond);
                EditText y=(EditText)findViewById(R.id.entnm);
                EditText z=(EditText)findViewById(R.id.entven);
                Approvals app=new Approvals(x.getText().toString(),y.getText().toString(),z.getText().toString());
                String ids=approvals.push().getKey();
                approvals.child(ids).setValue(app);
                Toast.makeText(RequestActivity.this,"Request Sent",Toast.LENGTH_LONG).show();
            }
        });

    }
}
