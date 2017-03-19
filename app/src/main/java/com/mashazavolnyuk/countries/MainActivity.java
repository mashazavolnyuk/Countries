package com.mashazavolnyuk.countries;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;
import com.mashazavolnyuk.countries.interfaces.IMapShower;

public class MainActivity extends AppCompatActivity implements IMapShower {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toCountriesList();
    }

    public void toMap() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, new FragmentMap()).commit();
    }

    public void toCountriesList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentCountriesList fragmentCountriesList = new FragmentCountriesList();
        fragmentCountriesList.setNavigation(this);
        fragmentManager.beginTransaction().replace(R.id.content, fragmentCountriesList).commit();
    }


    @Override
    public void showOnMap(LatLng latLng) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentMap fragmentMap = new FragmentMap();
        fragmentMap.setInfo(latLng);
        fragmentManager.beginTransaction().replace(R.id.content, fragmentMap).commit();
    }
}
