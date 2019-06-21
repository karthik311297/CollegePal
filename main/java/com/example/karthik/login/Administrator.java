package com.example.karthik.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Administrator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);
        final EditText user=(EditText)findViewById(R.id.Adid);
        final EditText pwd=(EditText)findViewById(R.id.Adpw);
        Button b=(Button)findViewById(R.id.Adlog);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u=user.getText().toString();
                String p=pwd.getText().toString();
                if(u.equals("Kart3112")&&p.equals("iyer121997")){
                    Intent xyz=new Intent(Administrator.this,Profile.class);
                    startActivity(xyz);
                }
            }
        });
    }
}
