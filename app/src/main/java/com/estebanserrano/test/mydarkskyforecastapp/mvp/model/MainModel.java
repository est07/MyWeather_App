package com.estebanserrano.test.mydarkskyforecastapp.mvp.model;

import android.support.annotation.NonNull;


import com.estebanserrano.test.mydarkskyforecastapp.service.GetWeatherResponse;
import com.estebanserrano.test.mydarkskyforecastapp.service.ListWeatherService;

import io.reactivex.observers.DisposableObserver;


public class MainModel {

    private ListWeatherService listWeatherService;

    public MainModel(ListWeatherService listWeatherService) {
        this.listWeatherService = listWeatherService;
    }

    public void getWeathers(@NonNull DisposableObserver<GetWeatherResponse> observer) {
          listWeatherService.getListWeather(observer);
    }

}
