package com.mashazavolnyuk.countries.data;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by mashka on 18.03.17.
 */

public class Country {

    private String capital;
    private String name;
    private String currency;
    private LatLng latLng;

    public Country(String nameCounry,String nameCapital){
        this.name = nameCounry;
        this.capital = nameCapital;
    }


    public String getCapital() {
        return capital;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }
    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

}
