package com.example.karthik.login;

public class Approvals {

    private String conducted;
    private String name;
    private String venue;
    public Approvals(){}
    public Approvals(String a,String b,String c){
        conducted=a;
        name=b;
        venue=c;
    }
    public String getName() {
        return name;
    }

    public String getConducted() {
        return conducted;
    }

    public String getVenue() {
        return venue;
    }
}
