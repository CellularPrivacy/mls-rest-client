package com.github.cellularprivacy.mlsrestclient.dto;

/**
 * @see <a href="https://mozilla.github.io/ichnaea/api/geolocate.html#response">https://mozilla.github.io/ichnaea/api/geolocate.html#response</a>
 */
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
