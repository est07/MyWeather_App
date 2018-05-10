package com.estebanserrano.test.mydarkskyforecastapp.service;


public class ServiceUtils {

    private static ListaWeatherService listaWeatherService;

    private ServiceUtils(){}

    public static final ListaWeatherService getItemService() {
        if (listaWeatherService == null) {
            listaWeatherService = new ListaWeatherService();
        }
        return listaWeatherService;
    }
}
