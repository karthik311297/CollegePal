package com.example.karthik.login;

public class Accounts {
    private String email;
    private String username;
    private String password;
    private String gender;
    public Accounts(String a,String b,String c,String d){
        email=a;
        username=b;
        password=c;
        gender=d;
    }
    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
