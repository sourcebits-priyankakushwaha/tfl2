package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import java.util.StringTokenizer;

public class TravelData {

    String from;
    String to;
    String when;
    String tavelPref;

    public TravelData(String from, String to,String when,String tavelPref) {
        this.from = from ;
        this.to = to ;
        this.when = when ;
        this.tavelPref = tavelPref;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }



    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getTavelPref() {
        return tavelPref;
    }

    public void setTavelPref(String tavelPref) {
        this.tavelPref = tavelPref;
    }
}
