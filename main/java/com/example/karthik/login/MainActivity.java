package com.example.karthik.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void loginPage(View view)
    {
        Intent login_page=new Intent(MainActivity.this,Login.class);
        startActivity(login_page);
    }
    public void signUpPage(View view){
        Intent sign_page=new Intent(MainActivity.this,signup.class);
        startActivity(sign_page);
    }
    public void Adminpage(View view){
        Intent i=new Intent(MainActivity.this,Administrator.class);
        startActivity(i);
    }

}
