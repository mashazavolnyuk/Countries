package com.mashazavolnyuk.countries.api;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mashka on 18.03.17.
 */

public interface ICountryRequest {

    @GET("all")
    Call<String> getCountries();
}
