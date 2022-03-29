package com.example.topweather.api;

public class EndPoints {

    public static final String ACCU_BASE_URL = "http://dataservice.accuweather.com/";
    public static final String TOP_CITY_WEATHER = "currentconditions/v1/topcities/{group}/?apikey="+AccuWeatherCredentials.API_KEY;
    public static final String LOCATION_FORECAST = "forecasts/v1/daily/5day/{locationKey}?apikey="+AccuWeatherCredentials.API_KEY+"&details=true&metric=true";

}
