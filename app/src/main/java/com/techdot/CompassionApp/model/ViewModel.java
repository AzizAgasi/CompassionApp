package com.techdot.CompassionApp.model;

import android.widget.MediaController;
import android.widget.VideoView;

public class ViewModel {
    String title = null;
    String content = null;
    int image = -1;
    String link = null;
    int sideImage = -1;
    int backgroundColor = -1;
    String videoLink = null;

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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getSideImage() {
        return sideImage;
    }

    public void setSideImage(int sideImage) {
        this.sideImage = sideImage;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

}
