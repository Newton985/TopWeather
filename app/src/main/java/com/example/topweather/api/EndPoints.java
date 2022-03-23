package com.example.topweather.api;

public class EndPoints {

    public static final String ACCU_BASE_URL = "http://dataservice.accuweather.com/";
    public static final String TOP_CITY_WEATHER = "currentconditions/v1/topcities/{group}/?apikey="+AccuWeatherCredentials.API_KEY;

}
