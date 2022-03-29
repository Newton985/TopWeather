package com.example.topweather.fragments.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.topweather.fragments.CityWeatherFragment;
import com.example.topweather.models.ForeCast;

import java.util.ArrayList;
import java.util.List;

public class ForecastsFragmentAdapter extends FragmentStateAdapter {

    List<ForeCast> foreCastList = new ArrayList<>();

    public ForecastsFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<ForeCast> foreCastList) {
        super(fragmentActivity);
        this.foreCastList = foreCastList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return CityWeatherFragment.newInstance(foreCastList.get(position));
    }

    @Override
    public int getItemCount() {
        return foreCastList.size();
    }
}
