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

import java.util.ArrayList;

public class Adaptlist extends ArrayAdapter<Clubinfo> {
    public Adaptlist(Context context, ArrayList<Clubinfo> clist)
    {
        super(context,0,clist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview==null) {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.clublayout, parent, false);
            }

        Clubinfo currentclub=getItem(position);

        TextView cnm=(TextView) listitemview.findViewById(R.id.namecsp);
        TextView cusn=(TextView) listitemview.findViewById(R.id.incharge);
        if(currentclub!=null){
            cnm.setText(currentclub.getName().toString());
            cusn.setText(currentclub.getInchargeusn().toString());
        }

        return  listitemview;
    }
}