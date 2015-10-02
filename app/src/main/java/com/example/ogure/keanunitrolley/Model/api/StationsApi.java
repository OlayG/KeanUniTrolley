package com.example.ogure.keanunitrolley.Model.api;


import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ogure on 10/1/2015.
 */
public interface StationsApi {

    @GET("/stations")
    void getStations(Callback<String> stations);
}
