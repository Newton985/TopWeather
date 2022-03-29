package com.example.topweather.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.topweather.R;
import com.example.topweather.databinding.ActivityCityWeatherBinding;
import com.example.topweather.fragments.adapter.ForecastsFragmentAdapter;
import com.example.topweather.models.ForecastsResponse;
import com.example.topweather.models.TopCity;
import com.example.topweather.staticfields.CurrentCityWeather;
import com.example.topweather.viewmodel.CityWeatherActivityViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Calendar;
import java.util.Date;

public class CityWeatherActivity extends AppCompatActivity {

    ActivityCityWeatherBinding activityCityWeatherBinding;
    CityWeatherActivityViewModel cityWeatherActivityViewModel;

    private final String [] weekDays= { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
    private int dayOfWeek = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       activityCityWeatherBinding = DataBindingUtil.setContentView(this,R.layout.activity_city_weather);

       String locationKey = getIntent().getStringExtra("locationKey");

       ViewModelProvider viewModelProvider = new ViewModelProvider(this);
       cityWeatherActivityViewModel = viewModelProvider.get(CityWeatherActivityViewModel.class);

       dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

       activityCityWeatherBinding.setTopCity(CurrentCityWeather.topCity);

       System.out.println("::::::::::::::::::::::::::::::::::::::"+dayOfWeek);

        cityWeatherActivityViewModel.forecastsResponseMutableLiveData.observe(this, new Observer<ForecastsResponse>() {
           @Override
           public void onChanged(ForecastsResponse forecastsResponse) {
               if (forecastsResponse != null) {
                   activityCityWeatherBinding.foreCastsViewPager.setAdapter(new ForecastsFragmentAdapter(CityWeatherActivity.this, forecastsResponse.getDailyForecasts()));
                   new TabLayoutMediator(activityCityWeatherBinding.weatherDatesTabLayout,
                           activityCityWeatherBinding.foreCastsViewPager,
                           ((tab, position) -> {
                                 if (position == 0){ tab.setText("Today"); }
                                 else{tab.setText(getTabHeader(position)); }

                           })).attach();
               }
           }
       });

       cityWeatherActivityViewModel.getCityForecast(locationKey);

    }

    private String getTabHeader(int position){
        String header = "";
        if (dayOfWeek + position < 7){ header = weekDays[dayOfWeek+position]; }
        else{  header = weekDays[dayOfWeek+position-7]; }

        return header;
    }
}