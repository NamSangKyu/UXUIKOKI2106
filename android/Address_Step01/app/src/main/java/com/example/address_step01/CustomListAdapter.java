package com.example.address_step01;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    public ArrayList<ListViewItem> list;

    public CustomListAdapter() {
        this.list = new ArrayList<ListViewItem>();
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
    public void addItem(Drawable profile, String name, String content, int id){
        list.add(new ListViewItem(profile,name,content,id));
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_list_view,viewGroup,false);
        }
        ImageView profile = view.findViewById(R.id.imageView);
        TextView name = view.findViewById(R.id.txt_name);
        TextView content = view.findViewById(R.id.txt_content);

        ListViewItem item = list.get(i);

        profile.setImageDrawable(item.getProfile());
        name.setText(item.getName());
        content.setText(item.getContent());

        return view;
    }
}
