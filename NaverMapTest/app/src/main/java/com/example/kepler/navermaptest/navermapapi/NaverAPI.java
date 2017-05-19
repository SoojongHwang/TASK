package com.example.kepler.navermaptest.navermapapi;

/**
 * Created by Kepler on 2017-05-15.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NaverAPI {
    @Headers({"X-Naver-Client-Id:hOBAjjmz9dUkwoGrp6pS","X-Naver-Client-Secret:ZjcaMrNM5I"})
    @GET("v1/map/geocode")
    Call<APIMapResult> getMap(@Query("query") String text, @Query("encoding") String encode);

    @Headers({"X-Naver-Client-Id:hOBAjjmz9dUkwoGrp6pS","X-Naver-Client-Secret:ZjcaMrNM5I"})
    @GET("v1/search/local.json")
    Call<APISearchResult> getSearch(@Query("query") String text);

}
