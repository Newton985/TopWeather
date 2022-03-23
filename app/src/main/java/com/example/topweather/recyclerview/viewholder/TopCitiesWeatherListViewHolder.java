package com.example.topweather.recyclerview.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.topweather.databinding.TopCityWeatherItemBinding;
import com.example.topweather.models.TopCity;

import java.util.Date;

public class TopCitiesWeatherListViewHolder extends RecyclerView.ViewHolder {

    public TopCityWeatherItemBinding topCityWeatherItemBinding;

    public TopCitiesWeatherListViewHolder(@NonNull TopCityWeatherItemBinding topCityWeatherItemBinding) {
        super(topCityWeatherItemBinding.getRoot());
        this.topCityWeatherItemBinding = topCityWeatherItemBinding;
    }

    public void bind(TopCity topCity){
        Date date = new Date(topCity.getEpochTime() * 1000);
        topCity.setFormatedDate(date.toString());
        topCity.setFormatedTemperature(topCity.getTemperature().getImperial().get("Value") + " \u2103");
        topCityWeatherItemBinding.setTopCity(topCity);
    }
}
