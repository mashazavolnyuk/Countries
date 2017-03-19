package com.mashazavolnyuk.countries.adapter;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mashazavolnyuk.countries.R;
import com.mashazavolnyuk.countries.data.Country;
import com.mashazavolnyuk.countries.interfaces.IMapShower;

import java.util.List;

/**
 * Created by mashka on 18.03.17.
 */

public class AdapterCountries extends RecyclerView.Adapter<AdapterCountries.HolderAdapter> {

    private List<Country> countries;
    private Context context;
    private IMapShower iMapShower;


    public AdapterCountries(Context context,List <Country> countries){
        this.context = context;
        this.countries = countries;
    }

    public AdapterCountries(Context context, List <Country> countries, IMapShower iMapShower){
        this.context = context;
        this.countries = countries;
        this.iMapShower = iMapShower;
    }

    @Override
    public HolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_countries, parent, false);
        return new HolderAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(HolderAdapter holder, final int position) {
        holder.country.setText(countries.get(position).getName());
        holder.capital.setText(countries.get(position).getCapital());
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup=new PopupMenu(context,v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_countries, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        menuItem(item,countries.get(position));
                    return true;
                    }
                });
                popup.show();

            }
        });
    }

    private boolean menuItem(MenuItem item,Country country) {

        switch (item.getItemId()) {

            case R.id.menu_moreInfo:
                Toast.makeText(context,
                        "Вы выбрали " + country.getName(),
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_showCountry:
               iMapShower.showOnMap(country.getLatLng());
                return true;
            default:
                return false;
        }
    }
    @Override
    public int getItemCount() {
        return countries.size();
    }


    class HolderAdapter extends RecyclerView.ViewHolder {
        public TextView country, capital,menu;

        public HolderAdapter(View view) {
            super(view);
            country = (TextView) view.findViewById(R.id.nameCountry);
            capital = (TextView) view.findViewById(R.id.nameCapital);
            menu = (TextView) view.findViewById(R.id.menuCountry);

        }
    }

}
