package com.example.searchapp;

public class ListViewItem {
    String title;
    String blogName;
    String url;

    @Override
    public String toString() {
        return "ListViewItem{" +
                "title='" + title + '\'' +
                ", blogName='" + blogName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ListViewItem(String title, String blogName, String url) {
        this.title = title;
        this.blogName = blogName;
        this.url = url;
    }
}
