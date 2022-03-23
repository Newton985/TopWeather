package com.example.topweather.viewmodel;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.topweather.models.TopCity;
import com.example.topweather.repository.TopCityWeatherRepository;

import java.util.List;

public class TopCitiesWeatherViewModel extends ViewModel {

    private final TopCityWeatherRepository topCityWeatherRepository;
    public MutableLiveData<List<TopCity>> topCityWeatherMutableLiveData;

    public TopCitiesWeatherViewModel(){
        topCityWeatherRepository = new TopCityWeatherRepository();
        topCityWeatherMutableLiveData = topCityWeatherRepository.getTopCityWeatherMutableLiveData();
    }

    public void getTopCitiesWeather(@Nullable Integer group){
        if (group == null){ topCityWeatherRepository.getTopCityWeather();}
        else { topCityWeatherRepository.getTopCityWeather(group); }
    }
}
