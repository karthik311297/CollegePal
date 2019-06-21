package com.example.karthik.login;

import android.widget.Spinner;

public class Projectinfo {
    private String ptl;
    private String stuname;
    private String  url;
    private String technology;

    private String technology2;

    private String technology3;

    public Projectinfo(){}
    public Projectinfo(String a,String b,String c,String d,String e,String f){
        ptl=a;
        stuname=b;
        url=c;
        technology=d;
        technology2=e;
        technology3=f;

    }

    public String getUrl() {
        return url;
    }

    public String getTechnology2() {
        return technology2;
    }

    public String getTechnology3() {
        return technology3;
    }

    public String getTechnology() {
        return technology;
    }

    public String getStuname() { return stuname; }

    public String getPtl() {
        return ptl;
    }
}
