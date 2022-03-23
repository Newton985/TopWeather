package com.example.topweather.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Temperature {

    @SerializedName("Metric")
    Map<String, String> metric;

    @SerializedName("Imperial")
    Map<String,String> imperial;

    public Map<String, String> getMetric() {
        return metric;
    }

    public void setMetric(Map<String, String> metric) {
        this.metric = metric;
    }

    public Map<String, String> getImperial() {
        return imperial;
    }

    public void setImperial(Map<String, String> imperial) {
        this.imperial = imperial;
    }
}