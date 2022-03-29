package com.example.topweather.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

@Entity(tableName = "TOP_CITY")
public class TopCity {

  @PrimaryKey()
  @SerializedName("Key")
  private String key;

  @ColumnInfo()
  @SerializedName("EnglishName")
  private String englishName;

  @ColumnInfo()
  @SerializedName("WeatherText")
  private String weatherText;

  @ColumnInfo()
  @SerializedName("HasPrecipitation")
  private Boolean hasPrecipitation;

  @ColumnInfo()
  @SerializedName("IsDayTime")
  private Boolean isDayTime;

  @SerializedName("Country")
  private Map<String, String> country;

  @SerializedName("EpochTime")
  private Long epochTime;

  private String formatedDate;

  private String formatedTemperature;

//  @ColumnInfo()
  @SerializedName("Temperature")
  private Temperature forecastTemperature;


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getEnglishName() {
    return englishName;
  }

  public void setEnglishName(String englishName) {
    this.englishName = englishName;
  }

  public String getWeatherText() {
    return weatherText;
  }

  public void setWeatherText(String weatherText) {
    this.weatherText = weatherText;
  }

  public Boolean getHasPrecipitation() {
    return hasPrecipitation;
  }

  public void setHasPrecipitation(Boolean hasPrecipitation) {
    this.hasPrecipitation = hasPrecipitation;
  }

  public Boolean getDayTime() {
    return isDayTime;
  }

  public void setDayTime(Boolean dayTime) {
    isDayTime = dayTime;
  }

  public Map<String, String> getCountry() {
    return country;
  }

  public void setCountry(Map<String, String> country) {
    this.country = country;
  }

  public Long getEpochTime() {
    return epochTime;
  }

  public void setEpochTime(Long epochTime) {
    this.epochTime = epochTime;
  }

  public String getFormatedDate() {
    return formatedDate;
  }

  public void setFormatedDate(String formatedDate) {
    this.formatedDate = formatedDate;
  }

  public String getFormatedTemperature() {
    return formatedTemperature;
  }

  public void setFormatedTemperature(String formatedTemperature) {
    this.formatedTemperature = formatedTemperature;
  }

  public Temperature getTemperature() {
    return forecastTemperature;
  }

  public void setTemperature(Temperature forecastTemperature) {
    this.forecastTemperature = forecastTemperature;
  }
}
