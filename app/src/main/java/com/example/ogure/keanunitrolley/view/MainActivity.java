package com.example.ogure.keanunitrolley.view;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;



import com.example.ogure.keanunitrolley.Model.pojo.Stations;
import com.example.ogure.keanunitrolley.Model.adapter.StationAdapter;
import com.example.ogure.keanunitrolley.R;
import com.example.ogure.keanunitrolley.controller.Controller;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Controller.StationsCallbackListener {

    private RecyclerView mRecyclerView;
    private List<Stations> mStationsList = new ArrayList<>();
    private StationAdapter mStationsAdapter;
    private Controller mController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configViews();
        mController.startFetching();

    }

    private void configViews() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.listView);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());

        mStationsAdapter = new StationAdapter(mStationsList);
        mRecyclerView.setAdapter(mStationsAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFetchStart() {

    }

    @Override
    public void onFetchProgress(Stations stations) { mStationsAdapter.addStation(stations); }

    @Override
    public void onFetchProgress(List<Stations> stationsList) {

    }

    @Override
    public void onFetchComplete() {

    }

    @Override
    public void onFetchFailed() {

    }
}
