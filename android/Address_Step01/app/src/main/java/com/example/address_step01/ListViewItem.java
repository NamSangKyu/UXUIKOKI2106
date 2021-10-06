package com.example.address_step01;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable profile;
    private String name;
    private String content;

    public ListViewItem(Drawable profile, String name, String content) {
        this.profile = profile;
        this.name = name;
        this.content = content;
    }

    public Drawable getProfile() {
        return profile;
    }

    public void setProfile(Drawable profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
