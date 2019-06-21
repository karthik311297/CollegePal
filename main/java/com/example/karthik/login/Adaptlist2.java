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

import com.example.karthik.login.Clubinfo;
import com.example.karthik.login.R;
import com.example.karthik.login.Startupinfo;

import java.util.ArrayList;

public class Adaptlist2 extends ArrayAdapter<Startupinfo> {

    public Adaptlist2(Context context, ArrayList<Startupinfo> slist)
    {
        super(context,0,slist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview==null) {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.clublayout, parent, false);
        }
        Startupinfo currentstartup=getItem(position);

        TextView cnm=(TextView) listitemview.findViewById(R.id.namecsp);
        TextView cusn=(TextView) listitemview.findViewById(R.id.incharge);
        if(currentstartup!=null){
            cnm.setText(currentstartup.getStartupName().toString());
            cusn.setText(currentstartup.getInchargeusn().toString());
        }
        return  listitemview;
    }
}
