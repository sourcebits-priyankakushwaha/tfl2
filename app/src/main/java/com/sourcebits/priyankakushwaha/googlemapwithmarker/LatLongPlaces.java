package com.sourcebits.priyankakushwaha.googlemapwithmarker;


public class LatLongPlaces {

    int _id;
    String _postcode;
    Double _lat;
    Double _lng;
    String _adrs;
    String _title;
    String _type;

    // Empty constructor
    public LatLongPlaces() {

    }

    public LatLongPlaces(String postcode, Double lat, Double lng, String adrs, String title, String type) {
        //this._id = id;
        this._postcode = postcode;
        this._lat = lat;
        this._lng = lng;
        this._adrs = adrs;
        this._title = title;
        this._type = type;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_postcode() {
        return _postcode;
    }

    public void set_postcode(String _postcode) {
        this._postcode = _postcode;
    }

    public Double get_lat() {
        return _lat;
    }

    public void set_lat(Double _lat) {
        this._lat = _lat;
    }

    public Double get_lng() {
        return _lng;
    }

    public void set_lng(Double _lng) {
        this._lng = _lng;
    }

    public String get_adrs() {
        return _adrs;
    }

    public void set_adrs(String _adrs) {
        this._adrs = _adrs;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

}
