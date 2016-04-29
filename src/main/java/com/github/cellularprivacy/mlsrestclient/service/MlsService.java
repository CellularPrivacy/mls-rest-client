package com.github.cellularprivacy.mlsrestclient.service;

import com.github.cellularprivacy.mlsrestclient.dto.Country;
import com.github.cellularprivacy.mlsrestclient.dto.GeolocateBody;
import com.github.cellularprivacy.mlsrestclient.dto.Geolocation;
import com.github.cellularprivacy.mlsrestclient.dto.Geosubmit2Body;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


@SuppressWarnings("unused")
public interface MlsService {

    /**
     * Determine the current location based on data provided about nearby Bluetooth, cell or WiFi networks and based on the IP address used to access the service.
     *
     * @param request
     * @return
     */
    @POST("v1/geolocate")
    Call<Geolocation> geolocate(
            @Body GeolocateBody request
    );

    /**
     * Determine the current region based on data provided about nearby Bluetooth, cell or WiFi networks and based on the IP address used to access the service.
     *
     * @return
     */
    @POST("v1/country")
    Call<Country> region(
            @Body GeolocateBody request
    );

    /**
     * Submit data about nearby Bluetooth beacons, cell or WiFi networks.
     *
     * @param request
     * @return Successful requests return a HTTP 200 response with a body of an empty JSON object.
     */
    @POST("v2/geosubmit")
    Call<JsonObject> geosubmit2(
            @Body Geosubmit2Body request
    );
}
