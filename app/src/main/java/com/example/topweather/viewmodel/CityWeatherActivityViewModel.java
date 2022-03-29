package com.example.topweather.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.topweather.models.ForecastsResponse;
import com.example.topweather.repository.TopCityWeatherRepository;

public class CityWeatherActivityViewModel extends ViewModel {
    public final MutableLiveData<ForecastsResponse> forecastsResponseMutableLiveData ;
    private final TopCityWeatherRepository topCityWeatherRepository = new TopCityWeatherRepository();

    public CityWeatherActivityViewModel(){
        forecastsResponseMutableLiveData = topCityWeatherRepository.getForecastsResponseMutableLiveData();
    }


    public void getCityForecast(String locationKey){
       topCityWeatherRepository.getLocationForeCast(locationKey);
    }

}
