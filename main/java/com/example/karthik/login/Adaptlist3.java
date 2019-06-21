package com.example.karthik.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.karthik.login.Projectinfo;
import com.example.karthik.login.R;
import com.example.karthik.login.Startupinfo;

import java.util.ArrayList;

public class Adaptlist3 extends ArrayAdapter<Projectinfo> {

    public Adaptlist3(Context context, ArrayList<Projectinfo> slist)
    {
        super(context,0,slist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview==null) {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.pjlaout, parent, false);
        }
        Projectinfo currentproject=getItem(position);

        TextView ptl=(TextView) listitemview.findViewById(R.id.ptitl);
        TextView stuname=(TextView) listitemview.findViewById(R.id.stunm);
        TextView stuid=(TextView)listitemview.findViewById(R.id.stuid);
        TextView tech1=(TextView)listitemview.findViewById(R.id.tech1);

        TextView tech2=(TextView)listitemview.findViewById(R.id.tech2);

        TextView tech3=(TextView)listitemview.findViewById(R.id.tech3);
        if(currentproject!=null){
            ptl.setText(currentproject.getPtl());
            stuname.setText(currentproject.getStuname());
            stuid.setText(currentproject.getUrl());
            tech1.setText(currentproject.getTechnology());
            tech2.setText(currentproject.getTechnology2());
            tech3.setText(currentproject.getTechnology3());
            }
        return  listitemview;
    }
}
