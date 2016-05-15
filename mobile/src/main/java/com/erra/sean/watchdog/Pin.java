package com.erra.sean.watchdog;

/**
 * Class that defines a Pin. A pin only cares about its location(LatLng, and the time it was placed.
 */
public class Pin {

    private double lat;
    private double lng;
    private String datetime;


    public Pin(double lat, double lng, String datetime) {
        this.lat = lat;
        this.lng = lng;
        this.datetime = datetime;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

}
