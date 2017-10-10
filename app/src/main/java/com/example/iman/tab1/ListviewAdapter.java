package com.example.iman.tab1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

import static com.example.iman.tab1.Constant.CALORY_COLUMN;
import static com.example.iman.tab1.Constant.FOODNAME_COLUMN;
import static com.example.iman.tab1.Constant.ID_COLUMN;

/**
 * Created by iman on 13/05/2017.
 */

public class ListviewAdapter extends BaseAdapter {

    public ArrayList<HashMap> list;
    Activity activity;

    public ListviewAdapter(Activity activity,ArrayList<HashMap> list)
    {
        super();
        this.activity=activity;
        this.list=list;
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
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView tvId;
        TextView tvFoodName;
        TextView tvCalory;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        LayoutInflater inflater=activity.getLayoutInflater();

        if (convertView==null){
            convertView=inflater.inflate(R.layout.listview_row,null);

            viewHolder=new ViewHolder();

            viewHolder.tvId= (TextView) convertView.findViewById(R.id.tvId);
            viewHolder.tvFoodName= (TextView) convertView.findViewById(R.id.tvFoodName);
            viewHolder.tvCalory= (TextView) convertView.findViewById(R.id.tvCalory);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        HashMap map=list.get(position);

        viewHolder.tvId.setText(map.get(ID_COLUMN).toString());
        viewHolder.tvFoodName.setText(map.get(FOODNAME_COLUMN).toString());
        viewHolder.tvCalory.setText(map.get(CALORY_COLUMN).toString());



        return convertView;
    }
}
