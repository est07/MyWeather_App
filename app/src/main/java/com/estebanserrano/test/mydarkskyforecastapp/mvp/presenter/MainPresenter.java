package com.estebanserrano.test.mydarkskyforecastapp.mvp.presenter;



import android.view.View;

import com.estebanserrano.test.mydarkskyforecastapp.mvp.model.MainModel;
import com.estebanserrano.test.mydarkskyforecastapp.mvp.view.MainView;
import com.estebanserrano.test.mydarkskyforecastapp.service.DataWeatherResponse;
import com.estebanserrano.test.mydarkskyforecastapp.service.GetWeatherResponse;

import java.util.ArrayList;

import io.reactivex.observers.DisposableObserver;


public class MainPresenter {

    private MainModel mainModel;
    private MainView mainView;

    private ArrayList<DataWeatherResponse> daily;

    public MainPresenter(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
        init();
    }

    public void init() {


        mainModel.getWeathers(new DisposableObserver<GetWeatherResponse>() {
            @Override
            public void onNext(GetWeatherResponse results) {
                mainView.init(results);

                daily= results.getDaily().getData();
                mainView.setDailyListItems(daily);

            }

            @Override
            public void onError(Throwable e) {
                mainView.showError();
                showSnack();
            }


            @Override
            public void onComplete() {
            }
        });
    }

    public void showSnack() {

        View.OnClickListener listener = v -> init();
        mainView.showErrorRed(listener);

    }


}
