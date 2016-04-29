package com.github.cellularprivacy.mlsrestclient.dto;

public class WifiAccessPoint {

    /**
     * The BSSID of the WiFi network.
     */
    public String macAddress;

    /**
     * The number of milliseconds since this network was last detected.
     */
    public Integer age;

    /**
     * The WiFi channel, often 1 - 13 for networks in the 2.4GHz range.
     */
    public Integer channel;

    /**
     * The frequency in MHz of the channel over which the client is communicating with the access point.
     * <p/>
     * This is an addition to the GLS API and can be used instead of the channel field.
     */
    public Integer frequency;

    /**
     * The received signal strength (RSSI) in dBm.
     */
    public Integer signalStrength;

    /**
     * The current signal to noise ratio measured in dB.
     */
    public Integer signalToNoiseRatio;

    /**
     * The SSID of the Wifi network.
     * <p/>
     * Wifi networks with a SSID ending in _nomap must not be collected.
     */
    public String ssid;
}
