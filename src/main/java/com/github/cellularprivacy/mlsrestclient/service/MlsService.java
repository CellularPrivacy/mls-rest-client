package com.github.cellularprivacy.mlsrestclient.service;

import com.github.cellularprivacy.mlsrestclient.dto.Country;
import com.github.cellularprivacy.mlsrestclient.dto.GeolocateBody;
import com.github.cellularprivacy.mlsrestclient.dto.Geolocation;
import com.github.cellularprivacy.mlsrestclient.dto.Geosubmit2Body;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @see <a href="https://mozilla.github.io/ichnaea/api/index.html">https://mozilla.github.io/ichnaea/api/index.html</a>
 */
public interface MlsService {

    /**
     * Determine the current location based on data provided about nearby Bluetooth, cell or WiFi networks and based on the IP address used to access the service.
     *
     * @return A successful response returns a position estimate and an accuracy field.
     * @see <a href="https://mozilla.github.io/ichnaea/api/geolocate.html>https://mozilla.github.io/ichnaea/api/geolocate.html</a>
     */
    @POST("v1/geolocate")
    Call<Geolocation> geolocate(
            @Body GeolocateBody request
    );

    /**
     * Determine the current region based on data provided about nearby Bluetooth, cell or WiFi networks and based on the IP address used to access the service.
     *
     * @see <a href="https://mozilla.github.io/ichnaea/api/region.html">https://mozilla.github.io/ichnaea/api/region.html</a>
     */
    @POST("v1/country")
    Call<Country> region(
            @Body GeolocateBody request
    );

    /**
     * Submit data about nearby Bluetooth beacons, cell or WiFi networks.
     *
     * @return Successful requests return a HTTP 200 response with a body of an empty JSON object.
     * @see <a href="https://mozilla.github.io/ichnaea/api/geosubmit2.html">https://mozilla.github.io/ichnaea/api/geosubmit2.html</a>
     */
    @POST("v2/geosubmit")
    Call<JsonObject> geosubmit2(
            @Body Geosubmit2Body request
    );
}
