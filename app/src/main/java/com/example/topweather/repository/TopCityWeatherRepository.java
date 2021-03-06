package com.example.topweather.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.example.topweather.models.ForecastsResponse;
import com.example.topweather.service.TopCityWeatherService;
import com.example.topweather.api.RetrofitServiceBuilder;
import com.example.topweather.models.TopCity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopCityWeatherRepository {

    private final MutableLiveData<List<TopCity>> topCityWeatherMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<ForecastsResponse> forecastsResponseMutableLiveData = new MutableLiveData<>();
    private final TopCityWeatherService topCityWeatherService;

    public TopCityWeatherRepository(){
        topCityWeatherService = RetrofitServiceBuilder.build(TopCityWeatherService.class);
    }

   public void getTopCityWeather(@Nullable Integer group){
        Integer cityGroup = group != null ? group : 50;

        topCityWeatherService.getTopCityWeather(cityGroup).enqueue(new Callback<List<TopCity>>() {
            @Override
            public void onResponse(@NonNull Call<List<TopCity>> call, @NonNull Response<List<TopCity>> response) {
               if (response.isSuccessful()){
                topCityWeatherMutableLiveData.setValue(response.body());
               }else {
                   //Fetch from local db

               }
            }

            @Override
            public void onFailure(@NonNull Call<List<TopCity>> call, @NonNull Throwable t) {

            }
        });

   }

   public void getTopCityWeather(){ getTopCityWeather(null);}


    public void  getLocationForeCast(String locationKey){
        topCityWeatherService.getLocationForeCast(locationKey).enqueue(new Callback<ForecastsResponse>() {
            @Override
            public void onResponse(@NonNull Call<ForecastsResponse> call, @NonNull Response<ForecastsResponse> response) {
                if (response.isSuccessful()){
                    forecastsResponseMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ForecastsResponse> call, @NonNull Throwable t) {

            }
        });
    }

    public MutableLiveData<List<TopCity>> getTopCityWeatherMutableLiveData() {
        return topCityWeatherMutableLiveData;
    }

    public MutableLiveData<ForecastsResponse> getForecastsResponseMutableLiveData() {
        return forecastsResponseMutableLiveData;
    }
}
