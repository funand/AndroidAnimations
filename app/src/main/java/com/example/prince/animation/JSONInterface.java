package com.example.prince.animation;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface JSONInterface {
    final String BASE_URL = "https://api.pexels.com/v1/search/";

    @GET("?query=Cars+query&per_page=50&page=2")
    @Headers("Authorization: 563492ad6f91700001000001c58d34921b984f809d791a62b1fe215e")
    Observable<DataClass> getData();

}
