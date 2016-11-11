/*
 * @(#)AirlineInfo.java  2016.11.09
 *
 * Copyright 2016 NHN Corp. All rights Reserved.
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.reve.common;

/**
 * @author giwoong.kim
 */
public class AirlineInfo {
    private int year;
    private int month;

    private String uniqueCarrier;

    private boolean arriveDelayAvailable = true;
    private int arriveDelayTime = 0;

    private boolean departureDelayAvailable = true;
    private int departureDelayTime = 0;

    private boolean distanceAvailable = true;
    private int distance = 0;

    public AirlineInfo(int year, int month, String uniqueCarrier, boolean arriveDelayAvailable, int arriveDelayTime, boolean departureDelayAvailable, int departureDelayTime, boolean distanceAvailable, int distance) {
        this.year = year;
        this.month = month;
        this.uniqueCarrier = uniqueCarrier;
        this.arriveDelayAvailable = arriveDelayAvailable;
        this.arriveDelayTime = arriveDelayTime;
        this.departureDelayAvailable = departureDelayAvailable;
        this.departureDelayTime = departureDelayTime;
        this.distanceAvailable = distanceAvailable;
        this.distance = distance;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getArriveDelayTime() {
        return arriveDelayTime;
    }

    public int getDepartureDelayTime() {
        return departureDelayTime;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isArriveDelayAvailable() {
        return arriveDelayAvailable;
    }

    public boolean isDepartureDelayAvailable() {
        return departureDelayAvailable;
    }

    public boolean isDistanceAvailable() {
        return distanceAvailable;
    }

    public String getUniqueCarrier() {
        return uniqueCarrier;
    }
}
