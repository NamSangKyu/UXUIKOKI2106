package com.example.searchapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    ArrayList<ListViewItem> list;

    public CustomListAdapter() {
        list = new ArrayList<ListViewItem>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_list_layout,viewGroup,false);
        }
        TextView title =view.findViewById(R.id.txt_title);
        TextView blogName=view.findViewById(R.id.txt_blog_name);

        ListViewItem item = list.get(i);
        title.setText(item.getTitle());
        blogName.setText(item.getBlogName());
        return view;
    }

    public void addItem(String title, String link, String bloggername) {
        list.add(new ListViewItem(title,bloggername,link));
    }
}





