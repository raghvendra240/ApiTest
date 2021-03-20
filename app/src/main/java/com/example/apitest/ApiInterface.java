package com.example.apitest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<Headlines> getHeadlines(@Query("country") String sources,
                                 @Query("apiKey") String apiKey);
}
