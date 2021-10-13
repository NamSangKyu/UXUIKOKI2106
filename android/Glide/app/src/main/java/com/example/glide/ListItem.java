package com.example.glide;

public class ListItem {
    private String imgUrl;
    private String title;
    private String content;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ListItem(String imgUrl, String title, String content) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.content = content;
    }
}
