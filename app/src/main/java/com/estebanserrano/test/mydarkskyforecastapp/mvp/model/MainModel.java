package com.estebanserrano.test.mydarkskyforecastapp.mvp.model;

import android.support.annotation.NonNull;


import com.estebanserrano.test.mydarkskyforecastapp.service.GetWeatherResponse;
import com.estebanserrano.test.mydarkskyforecastapp.service.ListaWeatherService;

import io.reactivex.observers.DisposableObserver;


public class MainModel {

    private ListaWeatherService listaWeatherService;

    public MainModel(ListaWeatherService listaWeatherService) {
        this.listaWeatherService = listaWeatherService;
    }

    public void getWeathers(@NonNull DisposableObserver<GetWeatherResponse> observer) {
          listaWeatherService.getListWeather(observer);
    }

}
