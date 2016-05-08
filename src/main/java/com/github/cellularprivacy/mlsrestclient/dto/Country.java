package com.github.cellularprivacy.mlsrestclient.dto;

import com.github.cellularprivacy.mlsrestclient.service.MlsService;

/**
 * @see MlsService#region(GeolocateBody)
 */
public class Country {

    public String country_code;

    public String country_name;

    public String fallback;
}
