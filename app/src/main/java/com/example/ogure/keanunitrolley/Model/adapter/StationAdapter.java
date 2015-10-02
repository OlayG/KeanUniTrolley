package com.example.ogure.keanunitrolley.Model.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ogure.keanunitrolley.Model.pojo.Stations;
import com.example.ogure.keanunitrolley.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogure on 10/1/2015.
 */
public class StationAdapter extends RecyclerView.Adapter<StationAdapter.Holder>{

    public static String TAG = StationAdapter.class.getSimpleName();
    private List<Stations> mStations;
    public StationAdapter(List<Stations> stations) { mStations = stations; }

    public void addStation(Stations station) {
        mStations.add(station);
        notifyDataSetChanged();
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.array_item, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Stations currentStation = mStations.get(position);
        holder.mName.setText(currentStation.mName);
        holder.mLatitude.setText(Double.toString(currentStation.mLatitude));
        holder.mLongitude.setText(Double.toString(currentStation.mLongitude));
    }

    @Override
    public int getItemCount() {
        return mStations.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView mName, mLatitude, mLongitude;

        public Holder(View itemView) {
            super(itemView);
            //mImage = (ImageView)
            mName = (TextView) itemView.findViewById(R.id.station_name);
        }
    }
}
