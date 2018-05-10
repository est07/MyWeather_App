package com.estebanserrano.test.mydarkskyforecastapp.adaters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.estebanserrano.test.mydarkskyforecastapp.R;
import com.estebanserrano.test.mydarkskyforecastapp.service.DataWeatherResponse;

import java.util.ArrayList;

public class DailyWeatherAdater extends RecyclerView.Adapter<DailyWeatherAdater.DailyViewHolder> {

//    public static final String TAG = DailyWeatherAdapter.class.getSimpleName();

    private ArrayList<DataWeatherResponse> days;
    private Context context;

    public DailyWeatherAdater(Context context, ArrayList<DataWeatherResponse> days){

        this.context = context;
        this.days = days;

    }


    @Override
    public DailyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.daily_list_item,parent,false);

        return new DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DailyViewHolder holder, int position) {

        DataWeatherResponse day = days.get(position);
        holder.onBind(day);
    }


    @Override
    public int getItemCount() {

        if (days==null)
            return 0;

        return days.size();
    }


    public static class DailyViewHolder extends RecyclerView.ViewHolder{

        TextView dayTitle;
        ImageView dayIcon;
        TextView dayTemperature;

        DailyViewHolder(View itemView) {
            super(itemView);

            dayTitle = (TextView) itemView.findViewById(R.id.txtDailyListTitle);
            dayIcon = itemView.findViewById(R.id.imvDailyListIcon);
            dayTemperature = (TextView) itemView.findViewById(R.id.txtDailyListTemperature);

        }

        public void onBind(final DataWeatherResponse day){

            dayTitle.setText(String.format("Day: %s", getLayoutPosition()));
            dayTemperature.setText(String.valueOf(day.getTemperatureMin())+"°");
        }
    }
}


