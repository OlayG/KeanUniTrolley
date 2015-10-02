package com.example.ogure.keanunitrolley.controller;


import android.util.Log;

import com.example.ogure.keanunitrolley.Model.pojo.Stations;
import com.example.ogure.keanunitrolley.Model.api.RestApiManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ogure on 10/1/2015.
 */
public class Controller {

    private static final String TAG = Controller.class.getSimpleName();
    private StationsCallbackListener mListening;
    private RestApiManager mApiManager;

    public Controller(StationsCallbackListener listener) {
        mListening = listener;
        mApiManager = new RestApiManager();
    }

    public void startFetching() {
        mApiManager.getStationsApi().getStations(new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d(TAG, "JSON :: " + s);

                try {
                    JSONArray array = new JSONArray(s);

                    for(int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        Stations stations = new Stations.Builder()
                                .setStationId(object.getInt("stationId"))
                                .setName(object.getString("name"))
                                .setLatitude(object.getDouble("latitude"))
                                .setLongitude(object.getDouble("longitude"))
                                .build();
                        mListening.onFetchProgress(stations);
                    }
                } catch (JSONException e) {
                    mListening.onFetchFailed();
                }

                mListening.onFetchComplete();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error :: " + error.getMessage());
                mListening.onFetchComplete();
            }
        });
    }

    public interface StationsCallbackListener {

        void onFetchStart();
        void onFetchProgress(Stations stations);
        void onFetchProgress(List<Stations> stationsList);
        void onFetchComplete();
        void onFetchFailed();
    }
}
