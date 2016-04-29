package com.github.cellularprivacy.mlsrestclient.service;

import com.github.cellularprivacy.mlsrestclient.MlsRestClient;
import com.github.cellularprivacy.mlsrestclient.dto.Country;
import com.github.cellularprivacy.mlsrestclient.dto.GeolocateBody;
import com.github.cellularprivacy.mlsrestclient.dto.Geolocation;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;

public class MlsServiceTest {

    MlsService mlsService;

    @Before
    public void setUp() throws Exception {
        mlsService = new MlsRestClient("test").getService();
    }

    @Test
    public void testGeolocate() throws Exception {
        Call<Geolocation> geolocationCall = mlsService.geolocate(new GeolocateBody());
        assertNotNull(geolocationCall);

        Response<Geolocation> geolocationResponse = geolocationCall.execute();
        assertNotNull(geolocationResponse);

        Geolocation geolocation = geolocationResponse.body();
        assertNotNull(geolocation);
    }

    @Test
    public void testRegion() throws Exception {
        Call<Country> countryCall = mlsService.region(new GeolocateBody());
        assertNotNull(countryCall);

        Response<Country> countryResponse = countryCall.execute();
        assertNotNull(countryResponse);

        Country country = countryResponse.body();
        assertNotNull(country);
    }
}