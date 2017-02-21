package cn.yumutech.mysimplenews.weather.model;

import android.content.Context;

/**
 * Created by 小豪 on 2017/2/21.
 */

public interface WeatherModel {
    void loadWeatherData(String cityName,WeatherModelImpl.LoadWeatherListener listener);
    void loadLocation(Context context, WeatherModelImpl.LoadLocationListener listener);
}
