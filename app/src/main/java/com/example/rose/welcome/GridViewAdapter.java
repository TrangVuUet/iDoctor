package com.example.rose.welcome;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rose.R;

import java.util.ArrayList;

/**
 * Created by Rose on 4/16/2015.
 */
public class GridViewAdapter extends ArrayAdapter<Item> {
    Context mContext;
    int layoutResourceId;
    ArrayList<Item> data = new ArrayList<Item>();

    public GridViewAdapter(Context mContext, int layoutResourceId, ArrayList<Item> list) {
        super(mContext,layoutResourceId,list);
        this.mContext = mContext;
        this.layoutResourceId = layoutResourceId;
        this.data = list;
    }

    public View getView(int pos, View convertView, ViewGroup parent) {
        View row = convertView;
        RecodeHolder holder = null;

        if(row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecodeHolder();
            holder.textItem = (TextView) row.findViewById(R.id.textView);
            holder.imageItem = (ImageView) row.findViewById(R.id.imageView);
            row.setTag(holder);

        } else {
            holder = (RecodeHolder) row.getTag();
        }

        Item item = data.get(pos);//data is arraylist
        holder.textItem.setText(item.getTitle());
        holder.imageItem.setImageBitmap(item.getImage());
        return row;
    }

    static class RecodeHolder {
        TextView textItem;
        ImageView imageItem;
    }
}
