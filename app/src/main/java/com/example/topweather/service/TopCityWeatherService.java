package com.example.topweather.service;

import com.example.topweather.api.EndPoints;
import com.example.topweather.models.ForecastsResponse;
import com.example.topweather.models.TopCity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TopCityWeatherService {

    @GET(EndPoints.TOP_CITY_WEATHER)
    Call<List<TopCity>> getTopCityWeather(@Path("group") Integer group);

    @GET(EndPoints.LOCATION_FORECAST)
    Call<ForecastsResponse> getLocationForeCast(@Path("locationKey") String locationKey);

}
