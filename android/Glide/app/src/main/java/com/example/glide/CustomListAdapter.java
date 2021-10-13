package com.example.glide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter  extends BaseAdapter {
    private ArrayList<ListItem> list;
    public CustomListAdapter(){list = new ArrayList<ListItem>();}

    public void AddItem(String url, String title, String content){
        list.add(new ListItem(url,title,content));
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
            view = inflater.inflate(R.layout.custom_list_item,viewGroup,false);
        }

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView title = view.findViewById(R.id.txt_title);
        TextView content = view.findViewById(R.id.txt_content);

        title.setText(list.get(i).getTitle());
        content.setText(list.get(i).getContent());

        Glide.with(view).load(list.get(i).getImgUrl())
                .placeholder(R.drawable.ic_launcher_background).into(imageView);

        return view;
    }
}
