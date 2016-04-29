package com.github.cellularprivacy.mlsrestclient.dto;

import java.util.Date;
import java.util.List;

public class Geosubmit2Report {

    /**
     * The time of observation of the data, measured in milliseconds since the UNIX epoch.
     * Can be omitted if the observation time is very recent.
     * The age values in each section are relative to this timestamp.
     */
    public Date timestamp;

    public Position position;

    public List<BluetoothBeacon> bluetoothBeacons;

    public List<CellTower> cellTowers;

    public List<WifiAccessPoint> wifiAccessPoints;

    /**
     * The position block contains information about where and when the data was observed.
     */
    public static class Position {

        /**
         * The latitude of the observation (WSG 84).
         */
        public Double latitude;

        /**
         * The longitude of the observation (WSG 84).
         */
        public Double longitude;

        /**
         * The accuracy of the observed position in meters.
         */
        public Double accuracy;

        /**
         * The age of the position data (in milliseconds).
         */
        public Integer age;

        /**
         * The altitude at which the data was observed in meters above sea-level.
         */
        public Double altitude;

        /**
         * The accuracy of the altitude estimate in meters.
         */
        public Double altitudeAccuracy;

        /**
         * The heading field denotes the direction of travel of the device and is specified in degrees, where 0° ≤ heading < 360°, counting clockwise relative to the true north.
         */
        public Double heading;

        /**
         * The air pressure in hPa (millibar).
         */
        public Double pressure;

        /**
         * The speed field denotes the magnitude of the horizontal component of the device’s current velocity and is specified in meters per second.
         */
        public Double speed;

        /**
         * The source of the position information. If the field is omitted, “gps” is assumed. The term gps is used to cover all types of satellite based positioning systems incl. Galileo and Glonass.
         * Other possible values are manual for a position entered manually into the system and fused for a position obtained from a combination of other sensors or outside service queries.
         */
        public String source;
    }

    public static class CellTower {

        /**
         * The type of radio network. One of gsm, wcdma or lte.
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
         * The number of milliseconds since this cell was last seen.
         */
        public Integer age;

        /**
         * The arbitrary strength unit indicating the signal strength if a direct signal strength reading is not available.
         */
        public Integer asu;

        /**
         * The primary scrambling code for WCDMA and physical cell id for LTE.
         */
        public Integer primaryScramblingCode;

        /**
         * A value of 1 indicates this as the serving cell, a value of 0 indicates a neighboring cell.
         */
        public Integer serving;

        /**
         * The signal strength for this cell network, either the RSSI or RSCP.
         */
        public Integer signalStrength;

        /**
         * The timing advance value for this cell tower when available.
         */
        public Integer timingAdvance;
    }

    public static class WifiAccessPoint extends com.github.cellularprivacy.mlsrestclient.dto.WifiAccessPoint {

        /**
         * The Wifi radio type, one of 802.11a, 802.11b, 802.11g, 802.11n, 802.11ac.
         */
        public String radioType;
    }
}
