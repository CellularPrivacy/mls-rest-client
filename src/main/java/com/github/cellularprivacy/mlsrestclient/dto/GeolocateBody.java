package com.github.cellularprivacy.mlsrestclient.dto;

import java.util.List;

/**
 * Created by larsgrefer on 26.04.16.
 */
public class GeolocateBody {


    /**
     * The clear text name of the cell carrier / operator.
     */
    public String carrier;


    /**
     * Should the clients IP address be used to locate it, defaults to true.
     */
    public Boolean considerIp;

    /**
     * The mobile country code stored on the SIM card.
     */
    public Integer homeMobileCountryCode;

    /**
     * The mobile network code stored on the SIM card.
     */
    public Integer homeMobileNetworkCode;

    public List<BluetoothBeacon> bluetoothBeacons;

    public List<CellTower> cellTowers;

    public List<WifiAccessPoint> wifiAccessPoints;

    public Fallbacks fallbacks;

    public static class CellTower {

        /**
         * The type of radio network. One of {@literal gsm}, {@literal wcdma} or {@literal lte}.
         * <p/>
         * This is a custom extension to the GLS API, which only defines the top-level radioType field.
         */
        public String radioType;

        /**
         * The mobile country code.
         */
        public int mobileCountryCode;

        /**
         * The mobile network code.
         */
        public int mobileNetworkCode;

        /**
         * The location area code for GSM and WCDMA networks. The tracking area code for LTE networks.
         */
        public int locationAreaCode;

        /**
         * The cell id or cell identity.
         */
        public int cellId;

        /**
         * The number of milliseconds since this networks was last detected.
         */
        public Integer age;

        /**
         * The primary scrambling code for WCDMA and physical cell id for LTE.
         * <p/>
         * This is an addition to the GLS API.
         */
        public Integer psc;

        /**
         * The signal strength for this cell network, either the RSSI or RSCP.
         */
        public Integer signalStrength;

        /**
         * The timing advance value for this cell network.
         */
        public Integer timingAdvance;
    }
}
