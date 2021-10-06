package com.example.customspinner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomSpinnerAdapter extends BaseAdapter {
    ArrayList<SpinnerItem> list;

    public CustomSpinnerAdapter() {
        list = new ArrayList<SpinnerItem>();
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
    public void addItem(Drawable drawable, String text){
        list.add(new SpinnerItem(drawable,text));
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_spinner,viewGroup,false);
        }
        ImageView img = view.findViewById(R.id.imageView);
        img.setImageDrawable(list.get(i).getDrawable());

        return view;
    }
}
