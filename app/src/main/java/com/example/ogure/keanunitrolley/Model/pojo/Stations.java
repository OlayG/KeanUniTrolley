package com.example.ogure.keanunitrolley.Model.pojo;

/**
 * Created by ogure on 10/1/2015.
 */
public class Stations {

    public int mStationId;
    public String mName;
    public double mLatitude, mLongitude;

    private Stations(Builder builder) {
        mStationId = builder.mStationId;
        mName = builder.mName;
        mLatitude = builder.mLatitude;
        mLongitude = builder.mLongitude;

    }

    public static class Builder {

        private int mStationId;
        private String mName;
        private double mLatitude, mLongitude;

        public Builder setStationId(int StationId) {
            mStationId = StationId;
            return Builder.this;
        }

        public Builder setName(String Name) {
            mName = Name;
            return Builder.this;
        }

        public Builder setLatitude(double Latitude) {
            mLatitude = Latitude;
            return Builder.this;
        }

        public Builder setLongitude(double Longitude) {
            mLongitude = Longitude;
            return Builder.this;
        }

        public Stations build() {
            return new Stations(Builder.this);
        }
    }
}
