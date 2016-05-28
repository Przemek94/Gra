package com.example.ziom.jtr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Przemek on 2016-05-27.
 */
public class PunktyAdepter extends ArrayAdapter {
    List list = new ArrayList();
    public PunktyAdepter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Punkty object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row = convertView;
        PunktyHolder punktyHolder;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            punktyHolder = new PunktyHolder();
            punktyHolder.tx_username = (TextView) row.findViewById(R.id.tx_username);
            punktyHolder.tx_points = (TextView) row.findViewById(R.id.tx_points);
            row.setTag(punktyHolder);

        }
        else {
            punktyHolder = (PunktyHolder) row.getTag();

        }
        Punkty punkty = (Punkty) this.getItem(position);
        punktyHolder.tx_username.setText(punkty.getUsername());
        punktyHolder.tx_points.setText(punkty.getPoints());
        return row;
    }

    static class PunktyHolder
    {
        TextView tx_username, tx_points;
    }
}
