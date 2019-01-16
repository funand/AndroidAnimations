package com.example.prince.animation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Photo {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("photographer")
    @Expose
    private String photographer;
    @SerializedName("photographer_url")
    @Expose
    private String photographerUrl;
    @SerializedName("src")
    @Expose
    private Src src;

    Photo(int id, String photographer, String photographerUrl, Src src, List<Photo> photos) {
        this.id = id;
        this.photographer = photographer;
        this.photographerUrl = photographerUrl;
        this.src = src;
    }

    public String getId() {
        return "Photo ID: " + id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getPhotographerUrl() {
        return photographerUrl;
    }

    public void setPhotographerUrl(String photographerUrl) {
        this.photographerUrl = photographerUrl;
    }

    public Src getSrc() {
        return src;
    }

    public void setSrc(Src src) {
        this.src = src;
    }


}

