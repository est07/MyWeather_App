package com.estebanserrano.test.mydarkskyforecastapp.mvp.view;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.estebanserrano.test.mydarkskyforecastapp.R;
import com.estebanserrano.test.mydarkskyforecastapp.adaters.DailyWeatherAdater;
import com.estebanserrano.test.mydarkskyforecastapp.service.Currently;
import com.estebanserrano.test.mydarkskyforecastapp.service.DataWeatherResponse;
import com.estebanserrano.test.mydarkskyforecastapp.service.GetWeatherResponse;
import com.estebanserrano.test.mydarkskyforecastapp.ui.ActivityView;
import com.estebanserrano.test.mydarkskyforecastapp.ui.MainActivity;

import java.util.ArrayList;


import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainView extends ActivityView<MainActivity> {

    @BindView(R.id.imvMainActivity)
    ImageView iconImageMainActivity;
    @BindView(R.id.txtCurrentDescription)
    TextView txtCurrentdescription;
    @BindView(R.id.txtCurrentTemperature)
    TextView txtcurrentTemperature;
    @BindView(R.id.txtWindSpeed)
    TextView txtWindSpeed;
    @BindView(R.id.txtOrientation)
    TextView txtOrientation;

    @BindView(R.id.txtPrecipProbability)
    TextView txtPrecipProbability;

    @BindView(R.id.rvDailyWeather)
    RecyclerView recyclerView;

    @BindString(R.string.error_connection_webservice)
    String errorMessge;



    private DailyWeatherAdater adapter;

    public static final String CLEAR_NIGHT = "clear-night";
    public static final String CLEAR_DAY = "clear-day";
    public static final String CLOUDY = "cloudy";
    public static final String PARTLY_CLOUDY_NIGHT = "partly-cloudy-night";
    public static final String FOG = "fog";
    public static final String NA = "na";
    public static final String PARTLY_CLOUDY_DAY = "partly-cloudy-day";
    public static final String RAIN = "rain";
    public static final String SLEET = "sleet";
    public static final String SNOW = "snow";
    public static final String SUNNY = "sunny";
    public static final String WIND = "wind";

    private String iconImage;

    ArrayList<DataWeatherResponse> days;


    @BindDrawable(R.drawable.clear_night)
    Drawable clearNight;
    @BindDrawable(R.drawable.clear_day)
    Drawable clearDay;
    @BindDrawable(R.drawable.cloudy)
    Drawable cloudy;
    @BindDrawable(R.drawable.cloudy_night)
    Drawable cloudyNight;
    @BindDrawable(R.drawable.fog)
    Drawable fog;
    @BindDrawable(R.drawable.na)
    Drawable na;
    @BindDrawable(R.drawable.partly_cloudy)
    Drawable partlyCloudy;
    @BindDrawable(R.drawable.rain)
    Drawable rain;
    @BindDrawable(R.drawable.sleet)
    Drawable sleet;
    @BindDrawable(R.drawable.snow)
    Drawable snow;
    @BindDrawable(R.drawable.sunny)
    Drawable sunny;
    @BindDrawable(R.drawable.wind)
    Drawable wind;



    public MainView(MainActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);



    }

    public void init(GetWeatherResponse getWeatherResponse) {

        Currently currentWeather = getWeatherResponse.getCurrently();
        days = getWeatherResponse.getDaily().getData();

        iconImage = currentWeather.getIcon();
        //iconImageView.setImageDrawable(getIconDrawableResource());
        txtCurrentdescription.setText(currentWeather.getSummary());
        txtcurrentTemperature.setText(String.valueOf(currentWeather.getTemperature())+"°");
        txtWindSpeed.setText(String.format("WS: %s", currentWeather.getWindSpeed())+"kph");
        txtPrecipProbability.setText(String.format("P: %s%%", currentWeather.getPrecipProbability()));



    }


    public Drawable getIconDrawableResource() {

        switch (iconImage) {
            case CLEAR_NIGHT:
                return clearNight;
            case CLEAR_DAY:
                return clearDay;
            case CLOUDY:
                return cloudy;
            case PARTLY_CLOUDY_NIGHT:
                return cloudyNight;
            case FOG:
                return fog;
            case NA:
                return na;
            case PARTLY_CLOUDY_DAY:
                return partlyCloudy;
            case RAIN:
                return rain;
            case SLEET:
                return sleet;
            case SNOW:
                return snow;
            case SUNNY:
                return sunny;
            case WIND:
                return wind;
            default:
                return na;

        }
    }

    public void showError() {
        Toast.makeText(getContext(), errorMessge, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


    public void setDailyListItems(ArrayList<DataWeatherResponse> dataWeatherArrayList){

        adapter = new DailyWeatherAdater(getContext(), dataWeatherArrayList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

    }



}
