package com.mashazavolnyuk.countries;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.mashazavolnyuk.countries.adapter.AdapterCountries;
import com.mashazavolnyuk.countries.data.Country;
import com.mashazavolnyuk.countries.interfaces.IMapShower;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mashka on 18.03.17.
 */

public class FragmentCountriesList extends Fragment {

    RecyclerView recyclerView;
    List <Country> countries;
    IMapShower iMapShower;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.fragment_countries_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rcvCountries);
        fillData();
        return view;
    }
    public void setNavigation(IMapShower navigation){
        this.iMapShower = navigation;
    }
    private void fillData(){
        countries = new ArrayList<>();
        Country country;
        for (int i=0;i<20;i++)
        {
            country =new Country("Uk","tes");
            LatLng latLng =new LatLng(49.0,32.0);
            country.setLatLng(latLng);
            countries.add(i,country);
        }
        recyclerView.setAdapter(new AdapterCountries(getActivity(),countries,iMapShower));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
