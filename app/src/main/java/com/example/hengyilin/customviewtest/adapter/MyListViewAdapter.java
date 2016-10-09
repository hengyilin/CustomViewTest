package com.example.hengyilin.customviewtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hengyilin.customviewtest.R;

import java.util.List;

/**
 * Created by hengyilin on 16-10-9.
 */

public class MyListViewAdapter extends ArrayAdapter<String> {

    public MyListViewAdapter(Context context, int textViewResourceId, List<String> strs) {
        super(context, textViewResourceId, strs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.mylistview_item_layout, null);
        } else {
            view = convertView;
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_mylistview_item);
        textView.setText(getItem(position));
        return view;
    }
}
