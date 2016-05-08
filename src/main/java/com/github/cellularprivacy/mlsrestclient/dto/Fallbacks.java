package com.github.cellularprivacy.mlsrestclient.dto;

public class Fallbacks {

    /**
     * If no exact cell match can be found, fall back from exact cell position estimates to more coarse grained cell location area estimates, rather than going directly to an even worse GeoIP based estimate.
     */
    public Boolean lacf;

    /**
     * If no position can be estimated based on any of the provided data points, fall back to an estimate based on a GeoIP database based on the senders IP address at the time of the query.
     */
    public Boolean ipf;
}
