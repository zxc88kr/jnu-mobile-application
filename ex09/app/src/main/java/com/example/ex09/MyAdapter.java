package com.example.ex09;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<MyItem> itemList = new ArrayList<>();

    public MyAdapter(ArrayList<MyItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public MyItem getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Context context = parent.getContext();
        View convertView = view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.listview_item, parent, false);

        TextView itemName = (TextView) convertView.findViewById(R.id.textView1);
        TextView itemChar = (TextView) convertView.findViewById(R.id.textView2);
        TextView itemWeight = (TextView) convertView.findViewById(R.id.textView3);
        ImageView itemIamge = (ImageView) convertView.findViewById(R.id.imageView);

        MyItem myItem = getItem(position);
        itemName.setText(myItem.getName());
        itemChar.setText(myItem.getCharacter());
        itemWeight.setText(myItem.getWeight());
        itemIamge.setImageResource(myItem.getImage());

        return convertView;
    }
}