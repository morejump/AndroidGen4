package com.project.phamhoang.weatherappnghean;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by phamhoang on 8/13/16.
 */
public interface GetService {
    @POST("/data/2.5/weather")
    Call<JSONModel> callJson(@Query("q") String location, @Query("APPID") String key);
}
