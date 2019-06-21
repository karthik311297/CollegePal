package com.example.karthik.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter4 extends ArrayAdapter<Approvals> {

    public Adapter4(Context context, ArrayList<Approvals> slist)
    {
        super(context,0,slist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview==null) {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.eventmenu, parent, false);
        }
        Approvals currentproject=getItem(position);

        TextView ptl=(TextView) listitemview.findViewById(R.id.mencond);
        TextView stuname=(TextView) listitemview.findViewById(R.id.mennm);
        TextView stuid=(TextView)listitemview.findViewById(R.id.menven);

        if(currentproject!=null){
            ptl.setText(currentproject.getConducted());
            stuname.setText(currentproject.getName());
            stuid.setText(currentproject.getVenue());
        }
        return  listitemview;
    }
}
