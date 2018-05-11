package com.estebanserrano.test.mydarkskyforecastapp.service.api;


import com.estebanserrano.test.mydarkskyforecastapp.service.GetWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WeatherClient {

    @GET(CostantsApi.DATAUBICACION)
    Call<GetWeatherResponse> getWeather(@Query("units") String unist);



}
