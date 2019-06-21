package com.example.karthik.login;

public class Stuinfo {
    private String name;
    private String dob;
    private String phno;
    private String usn;
    private String dept;
    public Stuinfo(){

    }
    public Stuinfo(String a,String b,String c,String d,String e){
        name=a;
        dob=b;
        phno=c;
        usn=d;
        dept=e;
    }
    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getPhno() {
        return phno;
    }

    public String getUsn() {
        return usn;
    }

    public String getDept() {
        return dept;
    }
}
