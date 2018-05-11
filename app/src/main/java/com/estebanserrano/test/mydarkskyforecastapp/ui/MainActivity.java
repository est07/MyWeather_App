package com.estebanserrano.test.mydarkskyforecastapp.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.estebanserrano.test.mydarkskyforecastapp.R;
import com.estebanserrano.test.mydarkskyforecastapp.mvp.model.MainModel;
import com.estebanserrano.test.mydarkskyforecastapp.mvp.presenter.MainPresenter;
import com.estebanserrano.test.mydarkskyforecastapp.mvp.view.MainView;
import com.estebanserrano.test.mydarkskyforecastapp.service.ServiceUtils;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        presenter = new MainPresenter(new MainModel(ServiceUtils.getItemService()),new MainView(this));

        presenter.init();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.checkIfGPSIsEnable();
    }

    private void checkIfGPSIsEnable(){
        try {

            int gpsSignal = Settings.Secure.getInt(getContentResolver(), Settings.Secure.LOCATION_MODE);

            if(gpsSignal ==0){
                showInfoAlert();
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showInfoAlert(){
        new AlertDialog.Builder(this)
                .setTitle("GPS Signal")
                .setMessage("El GPS no esta activo, desea activarlo.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("CANCEL", null)
                .show();
    }

}
