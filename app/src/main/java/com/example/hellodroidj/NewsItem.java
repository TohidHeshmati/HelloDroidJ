package com.example.hellodroidj;

public class NewsItem {
    private int id;
    private String title;
    private String subTitle;
    private String text;
    private int imageId;
    private String imageDescription;
    private String time;
    private String publisher;

    public NewsItem(int id, String title, String subTitle, String text, int imageId, String imageDescription, String time, String publisher) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.text = text;
        this.imageId = imageId;
        this.imageDescription = imageDescription;
        this.time = time;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
