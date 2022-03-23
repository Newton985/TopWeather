package com.example.topweather.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.topweather.R;
import com.example.topweather.databinding.TopCityWeatherItemBinding;
import com.example.topweather.models.TopCity;
import com.example.topweather.recyclerview.viewholder.TopCitiesWeatherListViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TopCitiesWeatherListAdapter extends RecyclerView.Adapter<TopCitiesWeatherListViewHolder> {

    List<TopCity> topCities = new ArrayList<>();

    public TopCitiesWeatherListAdapter(List<TopCity> topCities){
        this.topCities = topCities;
    }

    @NonNull
    @Override
    public TopCitiesWeatherListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TopCityWeatherItemBinding topCityWeatherItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.top_city_weather_item, parent, false);
        return  new TopCitiesWeatherListViewHolder(topCityWeatherItemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull TopCitiesWeatherListViewHolder holder, int position) {
         holder.bind(topCities.get(position));
    }

    @Override
    public int getItemCount() {
        return topCities.size();
    }
}
