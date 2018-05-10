package com.estebanserrano.test.mydarkskyforecastapp.service.api;


import com.estebanserrano.test.mydarkskyforecastapp.service.GetWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WeatherClient {

    //https://api.darksky.net/forecast/d5ef0c0795745ad537d736156d3118e7/37.8267,-122.4233?units=si
    @GET("37.8267,-122.4233")
    Call<GetWeatherResponse> getWeather(@Query("units") String unist);



}
