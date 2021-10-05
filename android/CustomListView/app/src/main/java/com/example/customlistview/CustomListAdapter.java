package com.example.customlistview;

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
    public void addItem(Drawable img, String txt){
        list.add(new ListViewItem(img,txt));
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_list_item,viewGroup,false);
        }
        //화면에 표시될 view로부터 위젯에 대한 참조 획득
        ImageView iconImageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        ListViewItem item = list.get(i);

        //리스트 아이템 - 이미지 셋팅
        iconImageView.setImageDrawable(item.getImgView());
        //리스트아이템 - 텍스트 셋팅
        textView.setText(item.getText());

        return view;
    }
}
