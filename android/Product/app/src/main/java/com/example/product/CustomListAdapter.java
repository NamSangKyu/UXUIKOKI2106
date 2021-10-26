package com.example.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<ProductDTO> list;

    public CustomListAdapter() {
        list = new ArrayList<ProductDTO>();
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
    public void addItem(ProductDTO dto){
        list.add(dto);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item,viewGroup,false);
        }

        TextView txtPno = view.findViewById(R.id.txt_pno);
        TextView txtPname = view.findViewById(R.id.txt_pname);
        TextView txtMaker = view.findViewById(R.id.txt_maker);
        TextView txtPrice = view.findViewById(R.id.txt_price);
        ProductDTO dto = list.get(i);
        txtPno.setText(String.valueOf(dto.getPno()));
        txtPname.setText(dto.getPname());
        txtMaker.setText(dto.getMaker());
        txtPrice.setText(String.valueOf(dto.getPrice()));
        return view;
    }
}
