package com.example.prince.animation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Src {

    @SerializedName("medium")
    @Expose
    private String medium;

    Src(String medium) {
        this.medium = medium;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
