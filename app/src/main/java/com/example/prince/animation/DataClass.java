package com.example.prince.animation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataClass {

    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos;
    @SerializedName("next_page")
    @Expose
    private String nextPage;

    public DataClass(Integer totalResults, Integer page, Integer perPage, List<Photo> photos, String nextPage) {
        this.totalResults = totalResults;
        this.page = page;
        this.perPage = perPage;
        this.photos = photos;
        this.nextPage = nextPage;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

}
