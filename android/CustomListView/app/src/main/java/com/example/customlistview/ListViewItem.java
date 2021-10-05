package com.example.customlistview;

import android.graphics.drawable.Drawable;

public class ListViewItem {
     private Drawable imgView;
     private String text;

    public ListViewItem(Drawable imgView, String text) {
        this.imgView = imgView;
        this.text = text;
    }

    public Drawable getImgView() {
        return imgView;
    }

    public void setImgView(Drawable imgView) {
        this.imgView = imgView;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
