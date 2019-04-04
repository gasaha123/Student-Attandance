package com.gaurav.sankalp.googlesignin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by gourav on 4/24/2018.
 */

public class CustomAdapter extends BaseAdapter{
    Context c;
    ArrayList<Students> roll=new ArrayList<Students>();
    LayoutInflater inflater;


    public CustomAdapter(Context c, ArrayList<Students> roll) {
        this.c = c;
        this.roll = roll;
    }





    @Override
    public int getCount() {
        return roll.size();
    }

    @Override
    public Object getItem(int i) {
        return roll.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {

        if (inflater== null)
        {
            inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } if(convertview==null)
        {
            convertview= inflater.inflate(R.layout.list_view_layout,viewGroup,false);

        }

        MyHolder holder= new MyHolder(convertview);
        holder.nametxt.setText(roll.get(i).getRoll());
        holder.presenttxt.setText(roll.get(i).getAttendance());
        holder.totaltext.setText(roll.get(i).getTotal());
        holder.percenttxt.setText(roll.get(i).getPercent());




        return convertview;
    }
}
