package com.tvd.cmri.other;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tvd.cmri.R;

import java.util.ArrayList;

public class FileAdapter extends BaseAdapter {
    private ArrayList<GetSetValues> arrayList;
    private LayoutInflater inflater;

    public FileAdapter(ArrayList<GetSetValues> arrayList, Context context) {
        this.arrayList = arrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_item, null);
        TextView tv_role = convertView.findViewById(R.id.tv);
        tv_role.setText(arrayList.get(position).getFile());
        return convertView;
    }
}
