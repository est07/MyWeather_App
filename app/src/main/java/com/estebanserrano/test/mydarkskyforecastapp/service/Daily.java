
package com.estebanserrano.test.mydarkskyforecastapp.service;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Daily  {

    @SerializedName("data")
    private ArrayList<DataWeatherResponse> data;

    public ArrayList<DataWeatherResponse> getData() {
        return data;
    }

    public void setData(ArrayList<DataWeatherResponse> data) {
        this.data = data;
    }

}
