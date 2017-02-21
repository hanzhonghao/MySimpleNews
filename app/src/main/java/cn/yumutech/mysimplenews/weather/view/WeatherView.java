package cn.yumutech.mysimplenews.weather.view;

import java.util.List;

import cn.yumutech.mysimplenews.beans.WeatherBean;

/**
 * Created by 小豪 on 2017/2/21.
 */

public interface WeatherView {

    void showProgress();
    void hideProgress();
    void showWeatherLayout();

    void setCity(String city);
    void setToday(String data);
    void setTemperature(String temperature);
    void setWind(String wind);
    void setWeather(String weather);
    void setWeatherImage(int res);
    void setWeatherData(List<WeatherBean> lists);

    void showErrorToast(String msg);

}
