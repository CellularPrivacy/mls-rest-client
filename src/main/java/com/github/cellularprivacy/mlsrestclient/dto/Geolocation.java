package com.github.cellularprivacy.mlsrestclient.dto;

public class Geolocation {

    public Location location;

    /**
     * The accuracy is measured in meters.
     */
    public int accuracy;

    public String fallback;

    public static class Location {

        public double lat;
        public double lng;

    }
}
