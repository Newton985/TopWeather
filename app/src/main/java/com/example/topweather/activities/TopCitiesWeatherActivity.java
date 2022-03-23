package com.example.topweather.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.topweather.R;
import com.example.topweather.databinding.ActivityTopCitiesWeatherBinding;
import com.example.topweather.models.TopCity;
import com.example.topweather.recyclerview.adapter.TopCitiesWeatherListAdapter;
import com.example.topweather.viewmodel.TopCitiesWeatherViewModel;

import java.util.List;

public class TopCitiesWeatherActivity extends AppCompatActivity {

    ActivityTopCitiesWeatherBinding activityTopCitiesWeatherBinding;
    TopCitiesWeatherViewModel topCitiesWeatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       activityTopCitiesWeatherBinding = DataBindingUtil.setContentView(this,R.layout.activity_top_cities_weather);
        activityTopCitiesWeatherBinding.topCitiesWeatherRecyclerView.setItemAnimator(new DefaultItemAnimator());
        activityTopCitiesWeatherBinding.topCitiesWeatherRecyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        topCitiesWeatherViewModel = viewModelProvider.get(TopCitiesWeatherViewModel.class);

        topCitiesWeatherViewModel.topCityWeatherMutableLiveData.observe(this, new Observer<List<TopCity>>() {
            @Override
            public void onChanged(List<TopCity> topCities) {
                 if (topCities != null && !topCities.isEmpty()){

                     TopCitiesWeatherListAdapter listAdapter = new TopCitiesWeatherListAdapter(topCities);
                     activityTopCitiesWeatherBinding.topCitiesWeatherRecyclerView.setAdapter(listAdapter);

                     for (int i=0 ; i < topCities.size(); i++){
                         listAdapter.notifyItemInserted(i);
                     }
                 }
            }
        });

        topCitiesWeatherViewModel.getTopCitiesWeather(null);

    }
}