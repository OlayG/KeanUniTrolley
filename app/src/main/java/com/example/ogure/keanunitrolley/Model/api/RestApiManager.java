package com.example.ogure.keanunitrolley.Model.api;

import com.example.ogure.keanunitrolley.Model.utilities.Constant;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;


/**
 * Created by ogure on 10/1/2015.
 */
public class RestApiManager {

    private StationsApi mStationsApi;

    public StationsApi getStationsApi() {

        if (mStationsApi == null) {
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());

            mStationsApi = new RestAdapter.Builder()
                    .setEndpoint(Constant.BASE_URL)
                    .setConverter(new GsonConverter((gson.create())))
                    .build()
                    .create(StationsApi.class);
        }
        return mStationsApi;
    }
}
