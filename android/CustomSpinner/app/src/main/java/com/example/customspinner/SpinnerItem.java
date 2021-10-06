package com.example.customspinner;

import android.graphics.drawable.Drawable;

public class SpinnerItem {
    private Drawable drawable;
    private String text;

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SpinnerItem(Drawable drawable, String text) {
        this.drawable = drawable;
        this.text = text;
    }
}
