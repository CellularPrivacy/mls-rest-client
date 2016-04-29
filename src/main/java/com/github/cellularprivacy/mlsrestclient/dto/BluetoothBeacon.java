package com.github.cellularprivacy.mlsrestclient.dto;

public class BluetoothBeacon {

    /**
     * The address of the Bluetooth Low Energy (BLE) beacon.
     */
    public String macAddress;

    /**
     * The number of milliseconds since this BLE beacon was last seen.
     */
    public Integer age;

    /**
     * The name of the BLE beacon.
     */
    public String name;

    /**
     * The measured signal strength of the BLE beacon in dBm.
     */
    public Integer signalStrength;
}
