package com.example.topweather.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.topweather.R;
import com.example.topweather.databinding.FragmentCityWeatherBinding;
import com.example.topweather.models.ForeCast;


public class CityWeatherFragment extends Fragment {


    private ForeCast foreCast;
    FragmentCityWeatherBinding fragmentCityWeatherBinding;

    public CityWeatherFragment() {
        // Required empty public constructor
    }

    public static CityWeatherFragment newInstance(ForeCast foreCast) {
        CityWeatherFragment fragment = new CityWeatherFragment();
        fragment.foreCast = foreCast;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCityWeatherBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_city_weather, container, false);
        fragmentCityWeatherBinding.setForeCast(foreCast);
        return fragmentCityWeatherBinding.getRoot();
    }
}