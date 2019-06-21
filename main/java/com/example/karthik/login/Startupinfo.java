package com.example.karthik.login;

public class Startupinfo {
    private String startupName;
    private String inchargeusn;
    public Startupinfo(){}

    public Startupinfo(String a,String b){
        startupName=a;
        inchargeusn=b;
    }
    public String getStartupName() {
        return startupName;
    }

    public String getInchargeusn() {
        return inchargeusn;
    }
}
